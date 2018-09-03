package com.car.modules.rest;

import com.car.modules.service.OnMessageService;
import com.car.modules.util.FormatUtil;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: Insertmessage
 * @description:
 * @date 2018/6/25：11:32
 */
@RestController
@RequestMapping(value="/car-info-api")
@Slf4j
@Component
@Api(tags="接收Mq异步消息入库")
public class InsertmessageRest {

    @Autowired
    private OnMessageService onMessageService;

    @RequestMapping(value = "/insertInfo",method = RequestMethod.POST)
    @ApiOperation(value="消息入库",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    public ResponseResult insertInfo(@RequestParam(value = "message" , required = true) String message){
        log.info("★★★★★★★★★★★★★★★★★接口收到请求------"+ FormatUtil.formatJson(message) );
        ResponseResult responseResult = new ResponseResult();
        try{
            onMessageService.onMessage(message);
            responseResult.setMessage("执行成功");
            responseResult.setStatus(Status.SUCCESS);
        }catch (Exception e){
            responseResult.setMessage("执行失败");
            responseResult.setStatus(Status.FAILED);
            responseResult.setData(e);
        }
        return responseResult;
    }
}
