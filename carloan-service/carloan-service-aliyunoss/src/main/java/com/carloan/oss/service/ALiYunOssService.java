package com.carloan.oss.service;

import java.io.InputStream;
import java.net.URL;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ALiYunOssService
 * @description:
 * @date 2018/7/25：9:06
 */
public interface ALiYunOssService {
    /**
     *
     * @description  功能描述:
     * @author       作        者: 周志伟
     * @description  功能描述: 上传文件
     * @Createdate   建立日期： 2017年3月24日下午2:57:47
     * @Projectname  项目名称: oss
     */
    public abstract String publicUpload(byte[] getBytes, String fileExt)throws Exception;
    /**
     *
     * @description  功能描述:
     * @author       作        者: 周志伟
     * @description  功能描述: 下载文件
     * @Createdate   建立日期： 2017年3月24日下午2:57:47
     * @Projectname  项目名称: oss
     */
    public abstract byte[]  download(String path) throws Exception;
    /**
     *
     * @description  功能描述:
     * @author       作        者: 周志伟
     * @description  功能描述: 根据key获取临时url可设置超时时间
     * @Createdate   建立日期： 2017年3月24日下午2:57:47
     * @Projectname  项目名称: oss
     */
    public String generatePresignedUrl(String key)  throws Exception;

    public abstract String upload(URL url, String fileExt)throws Exception;

    public abstract String upload(InputStream inputStream)throws Exception;

    public abstract String privateUpload(byte[] getBytes, String fileExt)throws Exception;


}
