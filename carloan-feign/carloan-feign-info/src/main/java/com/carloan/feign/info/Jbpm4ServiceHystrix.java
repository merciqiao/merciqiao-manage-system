package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.jbpm.ConsignTaskVO;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyl on 2018/8/8
 */
@Component
public class Jbpm4ServiceHystrix implements Jbpm4ServiceFeign{
    @Override
    public ResponseResult<Boolean> updateAssignee(ConsignTaskVO consignedTaskVO) {
        return GetResponseResult.result();
    }

    @Override
    public ResponseResult<Boolean> dispatchJob(String bizType, String activityName) {
        return GetResponseResult.result();
    }
}
