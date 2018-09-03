package com.carloan.oss.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import com.carloan.oss.config.OssProperties;
import com.carloan.oss.service.ALiYunOssService;
import com.carloan.oss.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: ALiYunOssServiceImpl
 * @description:
 * @date 2018/7/25：9:10
 */
@Service
@Slf4j
public class ALiYunOssServiceImpl implements ALiYunOssService {

    @Autowired
    private OssProperties ossProperties;

    /**
     *
     * @param getBytes
     * @param fileExt
     * @return
     */
    @Override
    public String publicUpload( byte[] getBytes,String fileExt) {
        String fileUrl= CommonUtil.getFileName(fileExt);
        String remotePath = ossProperties.getViedFile()+ fileUrl;
        OSSClient ossClient = null; // 创建OSSClient实例
        try {
            ossClient = new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
            ossClient.putObject(ossProperties.getBucketName(), fileUrl,new ByteArrayInputStream(getBytes));
            log.info("★[上传阿里云文件成功]★★[生成路径]["+ remotePath + "]");
        } catch (OSSException oe) {
            log.error("Error Message: 上传失败，获取不到OSSClient连接请求"
                    + oe.getErrorCode());
        } catch (Exception e) {
            log.error("上传到阿里云附件失败");
            e.printStackTrace();
        }finally {
            //关闭
            ossClient.shutdown();
        }
        return remotePath;
    }


    public byte[] download(String key) throws Exception {
        OSSClient ossClient = null;
        InputStream inputStream = null;
        byte[] filebyte = null;
        try {
            ossClient = new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
            OSSObject ossObject = ossClient.getObject(ossProperties.getBucketName(),key );
            inputStream = ossObject.getObjectContent();
            filebyte = CommonUtil.input2byte(inputStream);
            log.info("★[阿里云下载文件成功]★文件key[" + key + "]");
        } catch (OSSException oe) {
            log.error("Error Message: 下载失败，key不存在"
                    + oe.getErrorCode());
        } catch (ClientException ce) {
            log.error("下载失败");
            log.error("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            log.error("下载失败");
            log.error("throws Message: " + e.getMessage());
        } finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if (filebyte != null) {
                return filebyte;
            }
            ossClient.shutdown();
        }
        return null;
    }

    public String generatePresignedUrl(String key) throws Exception {
        OSSClient ossClient = null; // 创建OSSClient实例
        URL url = null;
        try {
            Date expiration = new Date(new Date().getTime() + ossProperties.getExpiration());
            ossClient = new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
            url = ossClient.generatePresignedUrl(ossProperties.getBucketName(), key, expiration, HttpMethod.GET);
            log.info("★★★★★★★★★[根据key获取临时url]★成功★[Key=" + key + "]★★[URL]★★["
                    + url + "]");
        } catch (OSSException oe) {
            log.info("Error Message: 生成临时url失败，获取不到OSSClient连接请求"
                    + oe.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("★★★★★★★★★[根据key获取临时url]★失败★[Key=" + key + "]★★");
            e.getStackTrace();
        } finally {
            if (url != null) {
                return url.toString();
            }
        }
        return null;
    }

    @Override
    public String upload(URL url, String fileExt) throws Exception {
        OSSClient ossClient = null; // 创建OSSClient实例
        try {
            ossClient = new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
            InputStream inputStream = url.openStream();
            PutObjectResult putObjectResult=ossClient.putObject(ossProperties.getBucketName(), "<yourObjectName>", inputStream);
            log.info("★[上传阿里云文件成功]★★[生成路径]["+ putObjectResult.getETag() + "]");
        } catch (OSSException oe) {
            log.error("Error Message: 上传失败，获取不到OSSClient连接请求"
                    + oe.getErrorCode());
        } catch (Exception e) {
            log.error("上传到阿里云附件失败");
            e.printStackTrace();
        }finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }

    @Override
    public String upload(InputStream inputStream) throws Exception {
        return null;
    }


    public String privateUpload( byte[] getBytes,String fileExt) {
        String fileUrl= CommonUtil.getFileName(fileExt);
        URL remotePath = null;
        OSSClient ossClient = null; // 创建OSSClient实例
        try {
            ossClient = new OSSClient(ossProperties.getEndpoint(),ossProperties.getAccessKeyId(),ossProperties.getAccessKeySecret());
            ossClient.putObject(ossProperties.getBucketName(), fileUrl,new ByteArrayInputStream(getBytes));
            Date expiration = new Date(new Date().getTime() + 36001 * 1000 * 24 * 365 * 10);
            remotePath = ossClient.generatePresignedUrl(ossProperties.getBucketName(), fileUrl, expiration, HttpMethod.GET);
            log.info("★[上传阿里云文件成功]★★[生成路径]["+ remotePath + "]");
        } catch (OSSException oe) {
            log.error("Error Message: 上传失败，获取不到OSSClient连接请求"
                    + oe.getErrorCode());
        } catch (Exception e) {
            log.error("上传到阿里云附件失败");
            e.printStackTrace();
        }finally {
            //关闭
            ossClient.shutdown();
            if (remotePath != null) {
                return remotePath.toString();
            }
        }
        return null;
    }
}
