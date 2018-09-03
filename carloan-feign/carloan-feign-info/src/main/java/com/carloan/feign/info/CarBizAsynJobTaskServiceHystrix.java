package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import org.springframework.stereotype.Component;

/**
 * Created by zhangyl on 2018/8/8
 */
@Component
public class CarBizAsynJobTaskServiceHystrix implements CarBizAsynJobTaskFeign{
    @Override
    public ResponseResult<Integer> executeAsynJob(int jobState) {
        return GetResponseResult.result();
    }
}
