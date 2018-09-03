package com.carloan.service.shiro.sysresource.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.RolePermission;
import com.carloan.apimodel.shiro.RolePermissionParam;
import com.carloan.common.utils.MapperUtil;
import com.carloan.service.shiro.sysresource.dto.SysResourceDTO;
import com.carloan.service.shiro.sysresource.service.SysResourceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: SysResourceController
 * @description: 定义  sys_resource 控制层
 * @author:  root
 */
@RestController
@RequestMapping(value="/shiro-api")
@Slf4j
@Component
public class SysResourceController{
    @Autowired
    SysResourceService sysResourceService;
    @Autowired
    MapperUtil mapperUtil;
    /**
     * 查询shiro的权限, URL-角色
     * @param rolePermissionParam
     * @return
     */
    @ApiOperation(value="查询shiro的权限, URL-角色",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/selectShiroRolePermission",method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroRolePermission(@RequestBody RolePermissionParam rolePermissionParam) throws Exception {
        ResponseResult<RolePermission> result = new ResponseResult<>();
        try {
            List<RolePermission> rolePermissionList=new ArrayList<>();

            SysResourceDTO sysResourceDTO=new SysResourceDTO();
            sysResourceDTO.setResoureType(rolePermissionParam.getResoureType());
            List<SysResourceDTO> sysRoleDTOList= sysResourceService.selectShiroRolePermission(sysResourceDTO);
            rolePermissionList=mapperUtil.map(sysRoleDTOList,RolePermission.class);
            result.setStatus(Status.SUCCESS);
            result.setDataList(rolePermissionList);
            result.setMessage("查询成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    /**
     * 查询shiro的权限, URL-角色
     * @param rolePermissionParam
     * @return
     */
    @ApiOperation(value="查询shiro的权限, URL-权限",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/selectShiroUrlPermission",method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroUrlPermission(@RequestBody RolePermissionParam rolePermissionParam) throws Exception {
        ResponseResult<RolePermission> result = new ResponseResult<>();
        try {
            List<RolePermission> rolePermissionList=new ArrayList<>();

            SysResourceDTO sysResourceDTO=new SysResourceDTO();
            sysResourceDTO.setResoureType(rolePermissionParam.getResoureType());
            List<SysResourceDTO> sysRoleDTOList= sysResourceService.selectShiroUrlPermission(sysResourceDTO);
            rolePermissionList=mapperUtil.map(sysRoleDTOList,RolePermission.class);
            result.setStatus(Status.SUCCESS);
            result.setDataList(rolePermissionList);
            result.setMessage("查询成功");

            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    /**
     * 根据userid查询shiro的权限
     * @param rolePermissionParam
     * @return
     */
    @ApiOperation(value="根据userid查询shiro的权限",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/selectShiroUrlPermissionByUserId",method = RequestMethod.POST)
    public ResponseResult<RolePermission> selectShiroUrlPermissionByUserId(@RequestBody RolePermissionParam rolePermissionParam) throws Exception {
        ResponseResult<RolePermission> result = new ResponseResult<>();
        try {
            List<RolePermission> rolePermissionList=new ArrayList<>();

            SysResourceDTO sysResourceDTO=new SysResourceDTO();
            sysResourceDTO.setUserId(rolePermissionParam.getUserId());
            sysResourceDTO.setResoureType(rolePermissionParam.getResoureType());
            List<SysResourceDTO> sysRoleDTOList= sysResourceService.selectShiroUrlPermissionByUserId(sysResourceDTO);
            rolePermissionList=mapperUtil.map(sysRoleDTOList,RolePermission.class);
            result.setStatus(Status.SUCCESS);
            result.setDataList(rolePermissionList);
            result.setMessage("查询成功");

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
