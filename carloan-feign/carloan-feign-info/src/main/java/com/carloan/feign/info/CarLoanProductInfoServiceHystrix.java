package com.carloan.feign.info;

import com.carloan.apimodel.common.GetResponseResult;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanHistoryDetailDTO;
import com.carloan.apimodel.order.CarLoanProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CarLoanProductInfoServiceHystrix implements CarLoanProductInfoServiceFeign{

    @Override
    public List<Map> querySysDictList(String code) {
        Map map=new HashMap();
        map.put("message","queryCarLoanPhoneHistory调用接口失败");
        map.put("status", Status.HYSTRIX_FAILED);
        List<Map> list=new ArrayList<>();
        list.add(map);
        log.info("queryCarLoanPhoneHistory调用接口失败");
        return list;
    }

    @Override
    public ResponseResult<CarLoanProductDTO> queryCarProductData() {
        return GetResponseResult.result();
    }
}
