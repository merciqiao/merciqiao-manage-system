package com.carloan.gateway.controller;

import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.order.CarLoanProductDTO;
import com.carloan.apimodel.order.CarProductPropertyDTO;
import com.carloan.feign.info.CarLoanProductInfoServiceFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.applet.Main;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/carinfo-product-api")
@Slf4j
@Api(tags = {"产品信息接口-shidoudou"})
public class CarLoanProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarLoanProductInfoServiceFeign feign;

    @ApiOperation(value="查询车贷产品信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/getProductInfoById",method = RequestMethod.GET)
    public CarLoanProductDTO getProductInfoById(@RequestParam("productCode") String productCode) throws Exception {
        CarLoanProductDTO productInfo=new CarLoanProductDTO();
        try {
            String url ="http://172.24.133.70:8080/masterdata/api/product/get/v1";
            String urlParam=url+"?type=loan&productCode="+productCode;
            ResponseEntity<Map> map = restTemplate.getForEntity(urlParam,Map.class);
            Map<String,Object> maps= (Map<String, Object>) map.getBody().get("responseBody");
            Map<String, Object> loan= (Map<String, Object>) maps.get("loan");
            setProductInfo(productInfo,loan);
            List<Map<String, String>> properties = (ArrayList<Map<String,String>>)maps.get("property");
            setProductProperties(productInfo, properties);
        }catch (Exception e){
            log.error("getProductInfoById异常", e);
            throw new Exception("getProductInfoById异常");
        }
        return productInfo;
    }

    private void setProductInfo(CarLoanProductDTO prodInfo, Map<String, Object> loan) throws Exception {
        try {
            prodInfo.setProductType(String.valueOf(loan.get("productType")));
            prodInfo.setProductName(loan.get("name")==null?"":String.valueOf(loan.get("name")));
            prodInfo.setProductCode(loan.get("code")==null?"":String.valueOf(loan.get("code")));
            prodInfo.setRepaymentWay(loan.get("repaymentWay")==null?"":String.valueOf(loan.get("repaymentWay")));
            prodInfo.setLoanPeriods(loan.get("loanPeriods")==null?"":String.valueOf(loan.get("loanPeriods")));
            prodInfo.setLoanPeriodList(filterSysdictByCode("LOANPERIODS", prodInfo.getLoanPeriods(), ","));
            //添加新定义：还款方式repaymentType
            prodInfo.setRepaymentType(loan.get("repaymentType")==null?"":String.valueOf(loan.get("repaymentType")));
            prodInfo.setLoanrepaymentType(filterSysdictByCode("LOANPAYTYPE", String.valueOf(loan.get("repaymentType")), ","));
        } catch (Exception e) {
            log.error("解析产品详细信息异常", e);
            throw new Exception("解析产品详细信息异常");
        }
    }

    private List filterSysdictByCode(String code, String filterStr, String regex) {
        List result = new ArrayList<Map<String, String>>();

        if(StringUtils.isEmpty(code) || StringUtils.isEmpty(filterStr)) {
            return result;
        }

        String[] filterArray = filterStr.split(regex);
        List<Map> sysDictDefList=feign.querySysDictList(code);
        if(CollectionUtils.isNotEmpty(sysDictDefList)){
            for(String codeO:filterArray) {
                for(Map map:sysDictDefList) {
                    if(codeO.equals(map.get("DICVALUE").toString())) {
                        result.add(map);
                    }
                }
            }
        }

        return result;
    }

    private void setProductProperties(CarLoanProductDTO prodInfo, List<Map<String, String>> properties) throws Exception {
        try {
            CarProductPropertyDTO productProp = null;

            for(Map<String, String> prop: properties) {
                productProp = new CarProductPropertyDTO();
                productProp.setCode(prop.get("code"));
                productProp.setMinValue(prop.get("minValue"));
                productProp.setMaxValue(prop.get("maxValue"));
                productProp.setDefaultValue(prop.get("defaultValue"));

                if("SERVICE_RATE".equals(prop.get("code"))) {
                    prodInfo.setServiceRateProp(productProp);
                } else if("LOAN_LIMIT".equals(prop.get("code"))) {
                    prodInfo.setLoanLimitProp(productProp);
                }
            }
        } catch (Exception e) {
            log.error("解析产品属性信息异常", e);
            throw new Exception("解析产品属性信息异常");
        }
    }

    @ApiOperation(value="查询车贷产品名称",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "GET")
    @RequestMapping(value = "/queryCarProductData",method = RequestMethod.GET)
    public ResponseResult<CarLoanProductDTO> queryCarProductData() throws Exception {
        ResponseResult<CarLoanProductDTO> result=new ResponseResult<>();
        try {
            result=feign.queryCarProductData();
        }catch (Exception e){
            log.error("queryCarProductData异常", e);
            throw new Exception("queryCarProductData异常");
        }
        return result;
    }

}
