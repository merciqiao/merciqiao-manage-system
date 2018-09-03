package com.carloan.feign.admin;

import com.carloan.apimodel.common.GetResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: SysPushMqServicefeignHystrix
 * @description:
 * @date 2018/8/17：11:18
 */
@Component
public class SysPushMqServicefeignHystrix implements SysPushMqServicefeign {
    @Override
    public Object PushMqCarMessge(String messageStr) {
        return GetResponseResult.result();
    }
}
