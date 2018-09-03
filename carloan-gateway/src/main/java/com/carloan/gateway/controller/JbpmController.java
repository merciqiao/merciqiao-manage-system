package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.jbpm.ConsignTaskVO;
import com.carloan.apimodel.shiro.UserInfo;
import com.carloan.common.shiro.MyShiroRealm;
import com.carloan.feign.info.Jbpm4ServiceFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by zhangyl on 2018/8/2
 */
@RestController
@RequestMapping(value="/jbpm-api")
public class JbpmController {
    @Autowired
    private Jbpm4ServiceFeign jbpm4ServiceFeign;

    @ApiOperation(value = "更换派单人", notes = "application/json")
    @RequestMapping(value = "updateAssignee", method = RequestMethod.POST)
    public ResponseResult<Boolean> updateAssignee(@RequestBody @Valid ConsignTaskVO consignedTaskVO, BindingResult result) {
        UserInfo curuser= MyShiroRealm.getUserInfo();
        consignedTaskVO.setCreateBy(curuser.getUserId().toString());
        jbpm4ServiceFeign.updateAssignee(consignedTaskVO);
        return new ResponseResult<>();
    }
}
