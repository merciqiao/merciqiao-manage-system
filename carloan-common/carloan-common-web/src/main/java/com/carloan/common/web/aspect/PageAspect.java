package com.carloan.common.web.aspect;

import com.alibaba.fastjson.JSONObject;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.common.web.annotation.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: RedisAspect
 * @description:
 *
 * AOP 实现分页查询
 * @date 2018/7/18：16:44
 */
@Component
@Aspect
public class PageAspect {
    Logger logger = LoggerFactory.getLogger(PageAspect.class);



    @Around("@annotation(page)")
    public Object page(ProceedingJoinPoint joinPoint, Page page) throws Throwable {
        Object object=null;
        ResponseResult<Object> result=new ResponseResult<Object>();
        try {
            logger.info("开始分页---方法名称：{}",joinPoint.getSignature().getName());
            Object[] arguments = joinPoint.getArgs();
            JSONObject json= (JSONObject) JSONObject.toJSON(arguments[0]);
            PageHelper.startPage(json.getInteger("currentPage"), json.getInteger("pageSize"));
            object = joinPoint.proceed();
            PageInfo<Object> pageInfo = new PageInfo((List) object);
            result.setDataList(pageInfo.getList());
            result.setCount((int) pageInfo.getTotal());
            result.setMessage("执行成功");
            logger.info("分页结束---方法名称：{}",joinPoint.getSignature().getName());
        }catch (Exception e){
            result.setStatus(Status.ERR_406);
            result.setMessage("参数错误");
            e.printStackTrace();
            }
        return result ;
    }



}
