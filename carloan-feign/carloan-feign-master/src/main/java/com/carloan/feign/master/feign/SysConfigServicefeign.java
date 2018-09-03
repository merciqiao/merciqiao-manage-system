package com.carloan.feign.master.feign;

import com.carloan.apimodel.common.ResponseResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.carloan.apimodel.master.SysConfigVo;

import java.util.List;

@FeignClient(value = "carloan-service-master", path = "/api/sysConfig", fallback = SysConfigServiceHystrix.class)
public interface SysConfigServicefeign {

    /**
     * 取得单个业务对象
     *
     * @return
     */
    @RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
    ResponseResult<Object> querySysConfigByPrimaryKey(@PathVariable("ID") String ID);

    @RequestMapping(value = "/getValueByCode/{code}", method = RequestMethod.POST)
    ResponseResult<String> getValueByCode(@PathVariable("code") String code);

    /**
     * 取得List业务对象
     *
     * @return
     */
    @RequestMapping(value = "/getSysConfigList", method = RequestMethod.POST)
    public ResponseResult<List<SysConfigVo>> querySysConfigList(@RequestBody SysConfigVo obj);


    /**
     * 根据对象查询信息返回单个实体
     *
     * @return
     */
    @RequestMapping(value = "/queryLike", method = RequestMethod.POST)
    public ResponseResult<Object> queryLikeSysConfig(@RequestBody SysConfigVo obj);


    /**
     * 创建业务对象
     *
     * @return
     */
    @RequestMapping(value = "/create/v1", method = RequestMethod.POST)
    public ResponseResult insertSysConfig(@RequestBody SysConfigVo obj);

    /**
     * 修改业务对象
     *
     * @return
     */
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    public ResponseResult updateSysConfig(@RequestBody SysConfigVo obj);

    /**
     * 假删除
     */
    @RequestMapping(value = "/deleteSysConfig/{ids}", method = RequestMethod.POST)
    public ResponseResult deleteSysConfig(@PathVariable("ids") String ids);


}
