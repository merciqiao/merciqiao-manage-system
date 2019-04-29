package com.carloan.api.model.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocketMsg {
    /* 消息来源sid */
    public String fromSID;
    /* 消息目标sid */
    public String toSID;
    /* 消息类型 */
    public String type;
    /* 消息体 */
    public String msg;
    /* 消息数据 */
    public String data;

    /* 房主sid */
    public Boolean isHomer;



    public String state="true";

    public static String ALL_COUNT="ALL_COUNT";//当前房间总数
    public static String QUEUE_STATE="QUEUE_STATE";//队列状态，有，无
    public static String INTO_GAME_COUNT="INTO_GAME_COUNT";//游戏中数量
    public static String INTO_MATCHING="INTO_MATCHING";//进入匹配
    public static String INTO_PREPARE="INTO_PREPARE";//进入准备中
    public static String INTO_GAME="INTO_GAME";//进入游戏
    public static String FRESH_TARGET_SCORE="FRESH_TARGET_SCORE";//刷新对方分数
    public static String GAME_OVER="GAME_OVER";//结束游戏
    public static String OUT_GAME="OUT_GAME";//退出游戏
    public static String CLOSE="CLOSE";//退出页面
}

