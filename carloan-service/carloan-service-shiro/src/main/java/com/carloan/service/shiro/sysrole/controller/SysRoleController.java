package com.carloan.service.shiro.sysrole.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.shiro.SysRole;
import com.carloan.apimodel.shiro.SysRoleParam;
import com.carloan.common.utils.MapperUtil;
import com.carloan.service.shiro.sysrole.dto.SysRoleDTO;
import com.carloan.service.shiro.sysrole.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @classname: SysRoleController
 * @description: 定义  sys_role 控制层
 * @author:  root
 */
@RestController
@RequestMapping(value="/shiro-api")
@Slf4j
@Component
public class SysRoleController{

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    MapperUtil mapperUtil;
    @ApiOperation(value="根据userid查询角色集合",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/getSysRoleByUserId",method = RequestMethod.POST)
    public ResponseResult<SysRole> getSysRoleByUserId(@RequestBody SysRoleParam sysRoleParam) throws Exception {
        ResponseResult<SysRole> result = new ResponseResult<>();
        try {
            List<SysRole> sysRoleList=new ArrayList<>();

            SysRoleDTO sysRoleDTO=new SysRoleDTO();
            sysRoleDTO.setTarget_id(sysRoleParam.getUserId());
            List<SysRoleDTO> sysRoleDTOList= sysRoleService.selectSysRoleByUserId(sysRoleDTO);
            sysRoleList= mapperUtil.map(sysRoleDTOList,SysRole.class);
            result.setStatus(Status.SUCCESS);
            result.setDataList(sysRoleList);
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
