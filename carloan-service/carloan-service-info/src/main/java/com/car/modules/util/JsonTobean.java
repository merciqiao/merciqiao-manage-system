package com.car.modules.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.car.modules.exceptionpackage.JsonException;
import com.car.modules.reqvo.ReqFuYiVo;
import com.car.modules.reqvo.ReqPriceVo;
import com.car.modules.reqvo.ReqUserInIfVo;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: JsonTobean
 * @description:
 * @date 2018/5/28：11:03
 */
public class JsonTobean {

    public static String gerValue(String msg,String val) throws JsonException {
        JSONObject jsonObject = JSONObject.parseObject(msg);
        if (jsonObject.getString(val)==null||jsonObject.getString(val)==""){
            throw new JSONException(val+"请求头属性不能为空");
        }
        return jsonObject.getString(val);
    }

    public  static ReqPriceVo getReqPriceVo(String msg) throws JSONException {
            ReqPriceVo reqPriceVo = (ReqPriceVo)JSONObject.parseObject(msg, ReqPriceVo.class);
            return reqPriceVo;
    }
    public  static ReqUserInIfVo getReqUserInIfVo(String msg) throws JSONException {
        ReqUserInIfVo reqUserInIfVo = (ReqUserInIfVo)JSONObject.parseObject(msg, ReqUserInIfVo.class);
        return reqUserInIfVo;
    }

    public  static ReqFuYiVo getReqFuYiVo(String msg) throws JSONException {
        ReqFuYiVo reqUserInIfVo = (ReqFuYiVo)JSONObject.parseObject(msg, ReqFuYiVo.class);
        return reqUserInIfVo;
    }

    public static <T> T entity(String text, Class<T> clazz) throws Exception {
        T entity= JSONObject.parseObject(text, clazz);
        return entity;
    }



}
