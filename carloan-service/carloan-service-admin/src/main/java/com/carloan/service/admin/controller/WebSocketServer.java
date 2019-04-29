package com.carloan.service.admin.controller;

import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.carloan.api.model.admin.SocketMsg;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;


@ServerEndpoint("/websocket/{sid}")
@Component
@Slf4j
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //存储游戏中的用户，Key是先准备的房主,value是成员
    private static Hashtable<String,String> dicList=new Hashtable<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";
    /* 游戏状态 */
    private String gameState="0";//0：未准备，1：已准备，2:游戏中
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("sid") String sid) {
        try {
            SocketMsg socketMsg = new SocketMsg();
            socketMsg.setFromSID(sid);
            if (this.checkExist(sid)) {
                try {
                    socketMsg.setType(SocketMsg.ALL_COUNT);
                    socketMsg.setMsg("已经连接成功");
                    Integer allCount = this.getOnlineCount();
                    socketMsg.setData(allCount.toString());
                    sendMessage(socketMsg);
                } catch (IOException e) {
                    log.error("websocket IO异常");
                }
            } else {

                this.sid = sid;
                this.session = session;
                webSocketSet.add(this);     //加入set中
                addOnlineCount();           //在线数加1
                this.freshCountAll();//刷新总人数
                this.freshIntoGameAll();//刷新游戏中数量
                this.freshQueueStateAll();//群刷新队列状态
                log.info("有新窗口开始监听:" + sid + ",当前在线人数为" + getOnlineCount());
            }
        }
        catch (Exception e){
            log.error("onOpen.error");
        }


    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() throws Exception{
        try {
            if(webSocketSet.contains(this)) {
                webSocketSet.remove(this);  //从set中删除
            }
            if (dicList.contains(this.sid)) {
                dicList.remove(this.sid);
            }
            subOnlineCount();           //在线数减1
            this.freshCountAll();//刷新所有人数
            this.freshIntoGameAll();//刷新游戏中数量
            this.freshQueueStateAll();//群刷新队列状态
            log.info("有一连接关闭:{},当前在线人数为" + getOnlineCount(), this.sid);
        }
        catch (Exception e){
            log.error("onClose error");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口"+sid+"的信息:"+message);
        try {
            SocketMsg socketMsg = JSON.parseObject(message, SocketMsg.class);
            //01.进入匹配
            if(socketMsg.getType().equals(SocketMsg.INTO_MATCHING)){
                //获取已经准备的
                WebSocketServer prePareUser= this.getPrePareUser(this.sid);
                if(prePareUser==null){
                    this.gameState="1";//准备中
                    this.freshQueueStateAll();//群刷新队列状态
                    this.intoPrePare();//自己进入准备中
                }
                else{
                    //有准备的则开始游戏
                    dicList.put(prePareUser.sid,this.sid);
                    this.freshPkState(prePareUser.sid,this.sid);//刷新PK状态
                    this.freshIntoGameAll();//刷新游戏中数量
                    this.freshQueueStateAll();//群刷新队列状态
                    this.pkGameStart(prePareUser.sid,this.sid);//双方开始游戏
                }

            }
            else if(socketMsg.getType().equals(SocketMsg.FRESH_TARGET_SCORE)){
                this.sendMessageTo(socketMsg);
            }
            else if(socketMsg.getType().equals(SocketMsg.GAME_OVER)){//游戏结束
                String targetSID= dicList.get(this.sid);
                dicList.remove(this.sid);
                this.freshPkState(this.sid,targetSID);//重置PK状态
                this.freshIntoGameAll();//刷新游戏中数量
                this.freshQueueStateAll();//群刷新队列状态
                this.pkGameOut(this.sid,targetSID);

            }
            else if(socketMsg.getType().equals(SocketMsg.CLOSE)){//游戏结束
                this.onClose();

            }
        }
        catch (Exception e){
            log.warn("非socketmsg对象消息");
        }

        //群发消息
//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
//        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        try {
            if (this.session.isOpen()) {
                this.session.getBasicRemote().sendText(message);
            }
        }
        catch (Exception e){
            log.error("sendMessage");
        }
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(SocketMsg message) throws IOException {
        try {
            String msg = JSON.toJSONString(message);
            if (this.session.isOpen()) {
                this.session.getBasicRemote().sendText(msg);
            }
        }
        catch (Exception e){
            log.error("sendMessage");
        }
    }
    /**
     * 实现服务器主动推送，群发
     */
    public void sendMessageAll(SocketMsg message) throws IOException {
        String toSID=message.getToSID();
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个toSID的，为null则全部推送
                if(toSID==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(toSID)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }
    /**
     * 发送到目标服务
     */
    public void sendMessageTo(SocketMsg message) throws IOException {
        String toSID=message.getToSID();
        for (WebSocketServer item : webSocketSet) {
            try {
                if(item.sid.equals(toSID)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }
    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
        log.info("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(sid==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(sid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
        if(webSocketSet.size()==0||WebSocketServer.onlineCount<0){
            WebSocketServer.onlineCount=0;
        }
    }
    private Boolean checkExist(String sid){
        boolean result=false;
        for (WebSocketServer item : webSocketSet){
            if(item.sid.equals(sid)){
                this.session=item.session;
                result=true;
            }
        }
        return  result;
    }

    /**
     * 获取准备中的用户
     * @param sid
     * @return
     */
    private WebSocketServer getPrePareUser(String sid){
        WebSocketServer user=null;
        for (WebSocketServer item : webSocketSet){
            if(!item.sid.equals(sid)&&item.gameState.equals("1")){
                user=item;
            }
        }
        return user;
    }

    /**
     * 刷新所有人的总人数
     */
    private void freshCountAll(){
        SocketMsg socketMsg=new SocketMsg();
        try {
            socketMsg.setType(SocketMsg.ALL_COUNT);
            socketMsg.setMsg("连接成功");
            Integer allCount=this.getOnlineCount();
            socketMsg.setData(allCount.toString());
            sendMessageAll(socketMsg);
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }
    /**
     * 刷新队列状态
     */
    private void freshQueueStateAll(){
        SocketMsg socketMsg=new SocketMsg();

        try {
            socketMsg.setType(SocketMsg.QUEUE_STATE);
            socketMsg.setMsg("更新队列状态");
            Integer allCount=this.getOnlineCount();
            String state="无";
            for (WebSocketServer item : webSocketSet){
                if(item.gameState.equals("1")){
                    state="有";
                }
            }
            socketMsg.setData(state);
            sendMessageAll(socketMsg);
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }
    /**
     * 刷新队列状态
     */
    private void intoPrePare() throws Exception{
        SocketMsg socketMsg=new SocketMsg();
        socketMsg.setType(SocketMsg.INTO_PREPARE);
        socketMsg.setMsg("进入准备中");
        this.sendMessage(socketMsg);
    }
    /**
     * 刷新游戏中数量
     */
    private void freshIntoGameAll(){
        SocketMsg socketMsg=new SocketMsg();

        try {
            socketMsg.setType(SocketMsg.INTO_GAME_COUNT);
            socketMsg.setMsg("更新游戏中数量");
            Integer allCount=dicList.size();
            socketMsg.setData(allCount.toString());
            sendMessageAll(socketMsg);
        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }
    /**
     * 刷新pk的人员状态
     */
    private void freshPkState(String oneSID,String twoSID){

            for (WebSocketServer item : webSocketSet){
               if(item.sid.equals(oneSID)||item.sid.equals(twoSID)){
                   item.gameState="2";
               }
            }
    }
    /**
     * 重置pk的人员状态
     */
    private void resetPkState(String oneSID,String twoSID){

        for (WebSocketServer item : webSocketSet){
            if(item.sid.equals(oneSID)||item.sid.equals(twoSID)){
                item.gameState="0";
            }
        }
    }
    /**
     * 双方开始游戏
     */
    private void pkGameStart(String oneSID,String twoSID) throws Exception{
        SocketMsg socketMsg=new SocketMsg();
        socketMsg.type=SocketMsg.INTO_GAME;
        for (WebSocketServer item : webSocketSet){
            if(item.sid.equals(oneSID)){
                socketMsg.toSID=twoSID;
                socketMsg.isHomer=true;//房主
                item.sendMessage(socketMsg);
            }
            else if(item.sid.equals(twoSID)){
                socketMsg.toSID=oneSID;
                item.sendMessage(socketMsg);
            }
        }
    }
    /**
     * 双方退出游戏
     */
    private void pkGameOut(String oneSID,String twoSID) throws Exception{
        SocketMsg socketMsg=new SocketMsg();
        socketMsg.type=SocketMsg.OUT_GAME;
        for (WebSocketServer item : webSocketSet){
            if(item.sid.equals(oneSID)){
                item.sendMessage(socketMsg);
            }
            else if(item.sid.equals(twoSID)){
                item.sendMessage(socketMsg);
            }
        }


    }
}

