package com.carloan.feign.master.feign;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.GetResponseResult;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.carloan.apimodel.master.SysConfigVo;

import java.util.List;

@Component
@Log
public class SysConfigServiceHystrix implements SysConfigServicefeign {
    @Override
    public ResponseResult<Object> querySysConfigByPrimaryKey(String message) {
        return GetResponseResult.result();
    }

    public ResponseResult<String> getValueByCode(String code) {
        return GetResponseResult.result();
    }

    public ResponseResult<List<SysConfigVo>> querySysConfigList(@RequestBody SysConfigVo obj) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<Object> queryLikeSysConfig(@RequestBody SysConfigVo obj) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<String> insertSysConfig(@RequestBody SysConfigVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<String> updateSysConfig(@RequestBody SysConfigVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<String> deleteSysConfig(String ids) {
        return GetResponseResult.result();

    }
}
