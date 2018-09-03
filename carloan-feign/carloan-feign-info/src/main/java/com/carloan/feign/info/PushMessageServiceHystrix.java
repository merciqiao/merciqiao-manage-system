package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: PushMessageServiceHystrix
 * @description:
 * @date 2018/7/9：15:47
 */
@Component
public class PushMessageServiceHystrix implements PushMessageServiceFeign {
    @Override
    public ResponseResult Stateofjudgment(String orderNumber, String status) {
        return GetResponseResult.result();
    }
}
