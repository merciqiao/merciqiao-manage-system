package com.carloan.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: CityController
 * @description:
 * @date 2018/7/18：15:23
 */
@RestController
@RequestMapping(value="/web-City-api")
@Slf4j
@Api(tags = {"城市区域-zhouzhiwei"})
public class CityController {

    @Autowired
    private RestTemplate restTemplate;



    @ResponseBody
    @RequestMapping(value = "/regionalList", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取全量一级区域", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseEntity<String>  regionalList()throws Exception{
        ResponseEntity<String> responseEntity=null;
        try{
            responseEntity = restTemplate.getForEntity("http://172.24.133.70:8761/regional", String.class);
            return responseEntity;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return responseEntity;

        }
    }


    @ResponseBody
    @RequestMapping(value = "/city", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "根据区域id获取城市", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "GET")
    public ResponseEntity<String>  regional(@RequestParam String id)throws Exception{
        ResponseEntity<String> responseEntity=null;
        try{
            responseEntity = restTemplate.getForEntity("http://172.24.133.70:8761/regional/{1}/city", String.class,id);
            return responseEntity;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return responseEntity;

        }
    }
}
