package com.carloan.oss.rest;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.oss.service.impl.ALiYunOssServiceImpl;
import com.carloan.oss.ueditor.ActionEnter;
import com.carloan.oss.ueditor.define.BaseState;
import com.carloan.oss.ueditor.define.State;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *
 * 上传附件到阿里云OSS
 *
 * zhouzhiwei
 *
 */
@RestController
@RequestMapping("/AliYunOss-api")
@Api(tags = {"阿里云oss-zhouzhiwei"})
@Slf4j
public class AliYunOssController {


	@Autowired
	private ALiYunOssServiceImpl aLiYunOssService;

	@Value("${OSS.configPath}")
	private  String configPath;

	/**
	 *
	 * @description  功能描述:此方法用于上传ueditor文本编辑器附件
	 * @author        周志伟
	 * @description  功能描述: 上传文件
	 * @Createdate   建立日期： 2018年7月25日下午2:57:47
	 * @Projectname  项目名称: oss
	 */
	@RequestMapping(value = "/upload")
	@ResponseBody
	@ApiOperation(value = "上传ueditor文本编辑器附件", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public String upload(HttpServletRequest request) throws Exception {
		log.info("初始化开始");
		State returnState = new BaseState(true);
		String rootPath = request.getRealPath("/");
		MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
		if (multipartRequest!=null) {
			MultipartFile importFile = multipartRequest.getFile("upfile");
			String suffix = importFile.getOriginalFilename().substring(importFile.getOriginalFilename().lastIndexOf("."));
			String showUrl = aLiYunOssService.privateUpload(importFile.getBytes(), suffix);
			returnState.putInfo("url", showUrl);
			returnState.putInfo("type", suffix);
			returnState.putInfo("original", importFile.getOriginalFilename());
			return returnState.toJSONString();
		}
		log.info("初始化结束");
		log.info("configPath:{}",configPath);
		return new ActionEnter( request, rootPath ,configPath).exec();
	}


	@PostMapping(value = "/uploadFile")
	@ResponseBody
	@ApiOperation(value = "上传附件", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public ResponseResult upload(@ApiParam MultipartFile importFile) throws Exception {
		ResponseResult result =new ResponseResult();
		try {
			String suffix = importFile.getOriginalFilename().substring(importFile.getOriginalFilename().lastIndexOf("."));
			String showUrl = aLiYunOssService.privateUpload(importFile.getBytes(), suffix);
			result.setStatus(Status.SUCCESS);
			result.setData(showUrl);
			result.setMessage("执行成功");
		}catch (Exception e){
			log.error(e.getMessage(),e);
			result.setStatus(Status.FAILED);
			result.setMessage(e.getMessage());
		}
		return result;

	}

	@RequestMapping("/getUrl")
	@ResponseBody
	@ApiOperation(value = "上传附件", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
	public String getUrl(@RequestParam String key) throws Exception {
		return aLiYunOssService.generatePresignedUrl(key);
	}








	}
