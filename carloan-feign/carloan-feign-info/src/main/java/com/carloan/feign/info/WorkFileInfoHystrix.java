package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.WorkFileInfoDTO;
import com.carloan.apimodel.order.WorkFileInfoParam;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Log
public class WorkFileInfoHystrix implements WorkFileInfoServicefeign {

    public ResponseResult<List<WorkFileInfoDTO>> query(@RequestBody WorkFileInfoParam param) {
        return GetResponseResult.result();
    }

}
