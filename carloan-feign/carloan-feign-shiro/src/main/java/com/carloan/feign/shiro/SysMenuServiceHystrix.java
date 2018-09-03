package com.carloan.feign.shiro;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.shiro.SysMenuVo;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @classname: SysMenuServiceHystrix
 * @description: 定义  sys_menu,微服务断路器
 * 一个微服务的超时失败可能导致瀑布式连锁反映Hystrix通过自主反馈实现的断路器，
 * 防止了这种情况发生调用失败达到一个特定的阀值(5秒之内发生20次失败是Hystrix定义的缺省值), 链路就会被处于open状态，
 * 之后所有所有对服务B的调用都不会被执行，
 * 取而代之的是由断路器提供的一个表示链路open的Fallback消息.  Hystrix提供了相应机制
 * @author: zhouzhiwei
 */
@Component
@Log
public class SysMenuServiceHystrix implements SysMenuServicefeign {

    @Override
    public ResponseResult<Object> querySysMenuByPrimaryKey(String message) {
        return GetResponseResult.result();

    }

    public ResponseResult<Object> querySysMenuList(@RequestBody SysMenuVo obj) {
        return GetResponseResult.result();
    }


    @Override
    public ResponseResult<Object> queryLikeSysMenu(@RequestBody SysMenuVo obj) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<String> insertSysMenu(@RequestBody SysMenuVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<String> updateSysMenu(@RequestBody SysMenuVo obj) {
        return GetResponseResult.result();

    }

    @Override
    public ResponseResult<SysMenuVo> querySysMenuByUserId(String userId) {
        return GetResponseResult.result();
    }
}
