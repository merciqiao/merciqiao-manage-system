package com.carloan.feign.info;

import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.order.Jbpm4BizTabVo;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: InserttheorderServiceHystrix
 * @description:
 * @date 2018/6/25：14:00
 */
@Component
@Slf4j
public class Jbpm4BizTabServiceHystrix implements  Jbpm4BizTabServiceFeign {
    @Override
    public Response insertJbpm4BizTab(Jbpm4BizTabParam jbpm4BizTabParam) {
       Response response=new Response();
       response.setStatus(Status.FAILED);
       response.setMessage("insertJbpm4BizTab.hystrix_failed");
       log.error("insertJbpm4BizTab.hystrix_failed");
       return  response;
    }

    @Override
    public ResponseResult<Jbpm4BizTabVo> findTaskInfoByOrderNum(Jbpm4BizTabParam jbpm4BizTabParam) {
        ResponseResult<Jbpm4BizTabVo> response=new ResponseResult<>();
        response.setStatus(Status.FAILED);
        response.setMessage("findTaskInfoByOrderNum.hystrix_failed");
        log.error("findTaskInfoByOrderNum.hystrix_failed");
        return  response;
    }

    @Override
    public Response updateJbpm4BizTabOver(String pro_instance_id) {
        Response response=new Response();
        response.setStatus(Status.FAILED);
        response.setMessage("updateJbpm4BizTabOver.hystrix_failed");
        log.error("updateJbpm4BizTabOver.hystrix_failed");
        return  response;
    }

    @Override
    public Response saveJbpm4BizTab(Jbpm4BizTabParam jbpm4BizTabParam) {
        Response response=new Response();
        response.setStatus(Status.FAILED);
        response.setMessage("saveJbpm4BizTab.hystrix_failed");
        log.error("saveJbpm4BizTab.hystrix_failed");
        return  response;
    }

    @Override
    public Response findJbpm4BizTabExist(Jbpm4BizTabParam jbpm4BizTabParam) {
        Response response=new Response();
        response.setStatus(Status.FAILED);
        response.setMessage("findJbpm4BizTabExist.hystrix_failed");
        log.error("findJbpm4BizTabExist.hystrix_failed");
        return  response;
    }
}
