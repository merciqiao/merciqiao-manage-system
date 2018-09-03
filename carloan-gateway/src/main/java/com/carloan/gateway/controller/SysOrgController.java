package com.carloan.gateway.controller;

import com.carloan.api.model.admin.SysOrgParam;
import com.carloan.api.model.admin.SysOrgVo;
import com.carloan.api.model.admin.TreeNodeVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;

import com.carloan.feign.admin.SysOrgServicefeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/6/27.
 */

@RestController
@RequestMapping(value="/sysorg-api")
@Slf4j
@Api(tags = {"组织机构接口-hanxiaoyan"})
public class SysOrgController {
    @Autowired
    private SysOrgServicefeign sysOrgfeignservice;


    @ApiOperation(value="新增机构信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/addOrg",method = RequestMethod.POST)
    public ResponseResult<Object> addOrg(@RequestBody SysOrgVo vo)throws Exception{
        ResponseResult<Object>result=new ResponseResult<>();
        try{
            if(vo!=null&&vo.getId()>0)
            {
                result=sysOrgfeignservice.updateSysOrg(vo);
            }
            else
            {
                result=sysOrgfeignservice.insertSysOrg(vo);
            }
            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="获取机构信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/querySysOrgList",method = RequestMethod.POST)
    public ResponseResult<List<TreeNodeVo>> querySysOrgList(@RequestBody SysOrgParam vo)throws Exception {
        ResponseResult<List<SysOrgVo>> result = new ResponseResult<>();
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {

            result=sysOrgfeignservice.querySysOrgList(vo);
            resulttree.setData(SysOrgVo.ToTreeModel(result.getData()));
            resulttree.setStatus(result.getStatus());
            return resulttree;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            resulttree.setStatus(Status.FAILED);
            resulttree.setMessage("执行异常,请重试");
            return resulttree;

        }
    }
//    @ApiOperation(value="新增机构用户关联信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
//    @RequestMapping(value = "/addOrgUser",method = RequestMethod.POST)
//    public ResponseResult<Object> addOrgUser(@RequestBody SysOrgUserVo vo)throws Exception {
//        ResponseResult<Object> result = new ResponseResult<>();
//        try {
//
//            result=sysOrgUserfeignservice.insertSysOrgUser(vo);
//
//            result.setStatus(Status.SUCCESS);
//            return result;
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//            result.setStatus(Status.FAILED);
//            result.setMessage("执行异常,请重试");
//            return result;
//
//        }
//    }
    @ApiOperation(value="根据主键id获取机构信息",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/querySysOrg",method = RequestMethod.POST)
    public ResponseResult<Object> querySysOrg(@RequestParam("") String orgid)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {
            result=sysOrgfeignservice.querySysOrgByPrimaryKey(orgid);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    @ApiOperation(value="根据主键id删除机构",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteSysOrg",method = RequestMethod.POST)
    public ResponseResult deleteSysOrg(@RequestParam("") String orgid)throws Exception {
        ResponseResult result = new ResponseResult<>();
        try {
            result=sysOrgfeignservice.deleteOrgByID(orgid);
            result.setStatus(Status.SUCCESS);
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


}
