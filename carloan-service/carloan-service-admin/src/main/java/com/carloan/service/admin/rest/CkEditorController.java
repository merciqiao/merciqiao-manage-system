package com.carloan.service.admin.rest;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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


    private static final String CK_IMAGE_PATH = File.separator + "uploadImage";
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ApiOperation(value = "上传图片", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public Map<String, String> upload(@RequestPart("upload") MultipartFile file, HttpServletRequest request)throws Exception{
        if(file==null || "".equals(file.getOriginalFilename().trim())) {
            return generateResult(false, "#");
        }
        String originalName = file.getOriginalFilename();
        // generate file name
        String localFileName = System.currentTimeMillis() + "-" + originalName;
        // get project path
        String projectRealPath = request.getSession().getServletContext().getRealPath("");
        // get the real path to store received images
        String realPath = projectRealPath + CK_IMAGE_PATH;
        File imageDir = new File(realPath);
        if(!imageDir.exists()) {
            imageDir.mkdirs();
        }

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
        String imageContextPath = "/api/"+request.getContextPath() + "/uploadImage" + "/" + localFileName;
        // log here +
        System.out.println("received file original name: " + originalName);
        System.out.println("stored local file name: " + localFileName);
        System.out.println("file stored path: " + localFilePath);
        System.out.println("returned url: " + imageContextPath);
        // log here -
        return generateResult(true, imageContextPath);
    }

    private Map<String, String> generateResult(boolean uploaded, String relativeUrl){
        Map<String, String> result = new HashMap<String, String>();
        result.put("uploaded", uploaded + "");
        result.put("url", relativeUrl);

        return result;
    }


}
