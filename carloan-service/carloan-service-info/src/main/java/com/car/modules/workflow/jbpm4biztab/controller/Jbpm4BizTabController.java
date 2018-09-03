package com.car.modules.workflow.jbpm4biztab.controller;


import com.car.modules.workflow.jbpm4biztab.dto.Jbpm4BizTabDTO;
import com.car.modules.workflow.jbpm4biztab.service.Jbpm4BizTabService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.Jbpm4BizTabParam;
import com.carloan.apimodel.order.Jbpm4BizTabVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @classname: Jbpm4BizTabController
 * @description: 定义  jbpm4_biz_tab 控制层
 * @author:  root
 */
@RestController
@RequestMapping(value="/car-info-api")
@Slf4j
@Component
public class Jbpm4BizTabController {
    @Autowired
    Jbpm4BizTabService jbpm4BizTabService;
    @Autowired
    Mapper mapper;
    @ApiOperation(value="插入订单和工作流关系表",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/insertJbpm4BizTab",method = RequestMethod.POST)
    public Response insertJbpm4BizTab(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam) throws Exception {
        Response result=new Response();
        try {
            Jbpm4BizTabDTO jbpm4BizTabDTO=mapper.map(jbpm4BizTabParam,Jbpm4BizTabDTO.class);
            Long iResult= jbpm4BizTabService.insertJbpm4BizTab(jbpm4BizTabDTO);

            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="根据订单号查询流程实例id",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findTaskInfoByOrderNum",method = RequestMethod.POST)
    public ResponseResult<Jbpm4BizTabVo> findTaskInfoByOrderNum(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam) throws Exception {
        ResponseResult<Jbpm4BizTabVo> result=new ResponseResult<>();
        try {
            Jbpm4BizTabDTO jbpm4BizTabDTO= jbpm4BizTabService.findTaskInfoByOrderNum(jbpm4BizTabParam.getBizInfNo(),jbpm4BizTabParam.getBizType());
            Jbpm4BizTabVo jbpm4BizTabVo = mapper.map(jbpm4BizTabDTO,Jbpm4BizTabVo.class);

            result.setData(jbpm4BizTabVo);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="根据流程实例id更新任务结束时间和结束标示",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateJbpm4BizTabOver",method = RequestMethod.POST)
    public Response updateJbpm4BizTabOver(@RequestParam String pro_instance_id) throws Exception {
        Response result=new Response();
        try {
            int iResult= jbpm4BizTabService.updateJbpm4BizTabOver(pro_instance_id);

            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="发起流程后,保存关系表",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/saveJbpm4BizTab",method = RequestMethod.POST)
    public Response saveJbpm4BizTab(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam) throws Exception {
        Response result=new Response();
        try {
            boolean iResult= jbpm4BizTabService.saveJbpm4BizTab(jbpm4BizTabParam);
            if(iResult){
                result.setStatus(Status.SUCCESS);
                result.setMessage("执行成功");
            }
            else{
                result.setStatus(Status.FAILED);
                result.setMessage("执行失败");
            }

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="查询未完成订单是否存在",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/findJbpm4BizTabExist",method = RequestMethod.POST)
    public Response findJbpm4BizTabExist(@RequestBody Jbpm4BizTabParam jbpm4BizTabParam) throws Exception {
        Response result=new Response();
        try {

            Boolean iResult= jbpm4BizTabService.findJbpm4BizTabExist(jbpm4BizTabParam.getBizInfId(),jbpm4BizTabParam.getBizType());
            if(iResult){
                result.setStatus(Status.SUCCESS);
                result.setMessage("已经发起流程");
            }
            else{
                result.setStatus(Status.FAILED);
                result.setMessage("发起流程失败");
            }

            //result.setStatus(Status.SUCCESS);
            //result.setMessage("执行成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
}
