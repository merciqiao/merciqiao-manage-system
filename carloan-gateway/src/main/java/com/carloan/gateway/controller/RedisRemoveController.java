//package com.carloan.gateway.controller;
//
//import com.carloan.apimodel.common.ResponseResult;
//import com.carloan.apimodel.common.Status;
//import com.carloan.common.redisTemplate.service.RedisUtils;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author 周志伟
// * @projectname 项目名称: ${project_name}
// * @classname: RedisRemoveController
// * @description:
// * @date 2018/7/19：16:34
// */
//@RestController
//@RequestMapping(value="/web-RedisRemove-api")
//@Slf4j
//@Api(tags = {"根据业务标识清空Redis缓存-zhouzhiwei"})
//public class RedisRemoveController {
//
//
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @ApiOperation(value="根据业务标识清空Redis缓存",httpMethod = "GET")
//    @RequestMapping(value = "/remove",method = RequestMethod.GET)
//    public ResponseResult<String> login(@RequestParam String key) throws Exception {
//        String keyval = key+"-*";
//        ResponseResult<String> result = new ResponseResult<>();
//        try {
//            redisUtils.removePattern(keyval);
//            result.setMessage("缓存清理成功");
//        }catch (Exception ex){
//            log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//        }
//        return result;
//
//    }
//
//
//}
