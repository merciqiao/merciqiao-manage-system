package com.carloan.oss.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CommonUtil
 * @description:
 * @date 2018/7/25：9:20
 */
public class CommonUtil {


    public static String getFileName(String fileExt){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String dateStr = format.format(new Date());
        String fileUrl = dateStr+ "/" + UUID.randomUUID().toString().replace("-","")+"/"+System.currentTimeMillis()+fileExt;
        return fileUrl;
    }

    public static final byte[] input2byte(InputStream inStream) throws IOException {
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in2b = swapStream.toByteArray();
            return in2b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
