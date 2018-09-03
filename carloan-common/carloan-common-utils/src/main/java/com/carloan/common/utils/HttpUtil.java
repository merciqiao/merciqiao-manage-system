package com.carloan.common.utils;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by MMM on 2017/08/21.
 */
@Slf4j
@Component
public class HttpUtil {

    /**
     * @param url
     * @param Params
     * @return
     * @throws IOException
     * @作用 使用urlconnection
     */
    public static String sendPost(String url, String Params) throws IOException {
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response = "";
        try {
            URL httpUrl = null; //HTTP URL类 用这个类来创建连接
            //创建URL
            httpUrl = new URL(url);
            //建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(20000);//连接超时 单位毫秒
            conn.setReadTimeout(20000);//读取超时
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST请求
            out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(Params);
            out.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                response += lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();
        } catch (Exception e) {
            log.error("httppost error:" + e.getMessage(), e);
            log.error("post url:" + url);
            log.error("post param:" + Params);
            log.error("httppost.error.result:" + response);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return response;
    }

    public static String sendGet(String url) {
        String response = "";
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection uRLConnection = (HttpURLConnection) httpUrl.openConnection();
            uRLConnection.setConnectTimeout(20000);//连接超时 单位毫秒
            uRLConnection.setReadTimeout(20000);//读取超时
            InputStream is = uRLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                //response = br.readLine();
                response = response + readLine;
            }
            is.close();
            br.close();
            uRLConnection.disconnect();
            return response;
        } catch (Exception e) {
            log.error("httpget error:" + e.getMessage(), e);
            log.error("httpget url" + url);
            log.error("httpget.error.result:" + response);
            return response;
        }
    }

}
