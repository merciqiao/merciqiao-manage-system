package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.feign.info.AliYunOssServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: AliYunOssController
 * @description:
 * @date 2018/7/27：14:16
 */
@RestController
@RequestMapping("/AliYunOss-api")
@Api(tags = {"阿里云oss-zhouzhiwei"})
@Slf4j
public class AliYunOssController {

    @Autowired
   private AliYunOssServiceFeign aliYunOssServiceFeign;


    @PostMapping(value = "/uploadFile")
    @ResponseBody
    @ApiOperation(value = "上传附件", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult upload(@ApiParam MultipartFile importFile) throws Exception {
        ResponseResult showUrl = aliYunOssServiceFeign.uploadFile(importFile);
        return showUrl;
    }


}
