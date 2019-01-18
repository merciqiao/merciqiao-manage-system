package com.carloan.service.admin.rest;

import com.alibaba.fastjson.JSON;
import com.carloan.common.utils.DateUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/img-api")
public class CkEditorController {

    /* 富文本编辑器上传图片位置*/
    private static final String CK_IMAGE_PATH = File.separator + "uploadImage";
    /* 文件管理上传文件位置*/
    private static final String CK_FILE_PATH = File.separator + "uploadFile";

    /**
     * 富文本编辑器上传图片
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ApiOperation(value = "上传图片", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public Map<String, String> uploadImg(@RequestPart("upload") MultipartFile file, HttpServletRequest request)throws Exception{
        String packageName=  CK_IMAGE_PATH + File.separator+DateUtil.GetDateShortNow();
        return this.upload(file,request,packageName);
    }

    /**
     * 上传文件
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiOperation(value = "上传文件", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public Map<String, String> uploadFile(@RequestPart("upload") MultipartFile file ,HttpServletRequest request)throws Exception{
        String packageName=CK_FILE_PATH + File.separator+DateUtil.GetDateShortNow();;

        return this.upload(file,request,packageName);
    }


    /**
     * 上传文件公共方法
     * @param file
     * @param request
     * @param packageName
     * @return
     */
    private Map<String, String> upload(@RequestPart("upload") MultipartFile file, HttpServletRequest request,String packageName){
        //为空判断
        if(file==null || "".equals(file.getOriginalFilename().trim())) {
            return generateResult(false, "#");
        }
        log.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        //原始文件名
        String originalName = file.getOriginalFilename();
        // 时间戳+原始文件名
        String localFileName = System.currentTimeMillis() + "-" + originalName;
        // tomcat地址存放文件
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        // 保存文件路径
        String realPath = projectRealPath + packageName;
        File imageDir = new File(realPath);
        if(!imageDir.exists()) {
            imageDir.mkdirs();
        }
        //文件名路径
        String localFilePath = realPath + File.separator + localFileName;
        try {
            file.transferTo(new File(localFilePath));
        } catch (IllegalStateException e) {
            e.printStackTrace();
            // log here
        } catch (IOException e) {
            e.printStackTrace();
            // log here
        }
        String imageContextPath = "/api/"+request.getContextPath() + packageName.replace("\\","") + "/" + localFileName;
        // log here +
        log.info("received file original name: " + originalName);
        log.info("stored local file name: " + localFileName);
        log.info("file stored path: " + localFilePath);
        log.info("returned url: " + imageContextPath);
        // log here -
        return generateResult(true, imageContextPath);
    }

    /**
     * 返回结果
     * @param uploaded
     * @param relativeUrl
     * @return
     */
    private Map<String, String> generateResult(boolean uploaded, String relativeUrl){
        Map<String, String> result = new HashMap<String, String>();
        result.put("uploaded", uploaded + "");
        result.put("url", relativeUrl);

        return result;
    }



}
