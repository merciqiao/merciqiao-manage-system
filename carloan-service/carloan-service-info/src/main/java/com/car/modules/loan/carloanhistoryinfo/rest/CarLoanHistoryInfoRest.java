package com.car.modules.loan.carloanhistoryinfo.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.car.modules.loan.carloanhistoryinfo.dto.CarLoanHistoryDetailDTO;
import com.car.modules.loan.carloanhistoryinfo.service.CarLoanHistoryInfoService;
import com.car.modules.loan.carloanhistoryinfo.util.HttpUtil;
import com.car.modules.loan.carloanhistoryinfo.util.PageUtil;
import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;
import com.car.modules.loan.carloanmsg.service.CarLoanMsgService;
import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;
import com.car.modules.loan.carloanuser.service.CarLoanUserService;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import com.carloan.apimodel.order.CarLoanUserVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import sun.security.util.ManifestEntryVerifier;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value="/car-history-info")
public class CarLoanHistoryInfoRest{

    @Autowired
    private CarLoanHistoryInfoService historyInfoService;

    @Autowired
    private CarLoanUserService userService;

    @Autowired
    private CarLoanMsgService msgService;

    @ApiOperation(value="根据orderNumber查询手机号匹配订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/queryCarLoanPhoneHistory",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> queryCarLoanPhoneHistory(@RequestParam("orderNumber")String orderNumber) throws Exception {
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        List<CarLoanHistoryDetailDTO> list=new ArrayList<CarLoanHistoryDetailDTO>();
        CarLoanHistoryDetailDTO carLoanHistoryDetailDTO=new CarLoanHistoryDetailDTO();
        try{
            CarLoanUserDTO dto=new CarLoanUserDTO();
            CarLoanUserDTO carLoanUserDTO=new CarLoanUserDTO();
            dto.setOrderNumber(orderNumber);
            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            CarLoanUserDTO CarLoanUserDTO=userService.searchCarLoanUserByDetail(searchParams);
            if(CarLoanUserDTO!=null){
                String phoneNumber=CarLoanUserDTO.getPhoneNumber();
                carLoanUserDTO.setPhoneNumber(phoneNumber);
                carLoanUserDTO.setOrderNumber(orderNumber);
                List<CarLoanHistoryDetailDTO> phoneHistoryList=historyInfoService.queryCarLoanPhone(carLoanUserDTO);
                if(CollectionUtils.isNotEmpty(phoneHistoryList)){
                    for (int i = 0; i < phoneHistoryList.size(); i++) {
                        phoneHistoryList.get(i).setIsCarXin("1");
                    }
                    list.addAll(phoneHistoryList);
                }
                List<CarLoanHistoryDetailDTO> contactPhoneList=historyInfoService.queryCarLoanContactPhone(carLoanUserDTO);
                if(CollectionUtils.isNotEmpty(contactPhoneList)){
                    for (int i = 0; i < contactPhoneList.size(); i++) {
                        contactPhoneList.get(i).setIsCarXin("1");
                    }
                    list.addAll(contactPhoneList);
                }
                /*Map<String, String> map=new HashMap<>();
                map.put("phoneNumber",phoneNumber);
                try {
                    String carList= HttpUtil.sendPost("http://172.24.133.70:8080/loan/api/carLoanHistory/getLoanCarPhone",map);
                    List<CarLoanHistoryDetailDTO> historyDetailList= JSONArray.parseArray(carList,CarLoanHistoryDetailDTO.class);
                    if(CollectionUtils.isNotEmpty(historyDetailList)){
                        list.addAll(historyDetailList);
                    }
                }catch (Exception a){
                    a.printStackTrace();
                    log.error("执行查询信审getCarPhone异常",a);
                }*/
                carLoanHistoryDetailDTO.setPhoneNumber(phoneNumber);
            }
            result.setData(carLoanHistoryDetailDTO);
            result.setDataList(list);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("执行getCarPhone异常",e);
        }
        return result;
    }

    @ApiOperation(value="根据orderNumber查询车牌号匹配订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/getCarNumber",method = RequestMethod.POST)
    public ResponseResult<CarLoanHistoryDetailDTO> getCarNumber(@RequestParam("orderNumber")String orderNumber) throws Exception {
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        List<CarLoanHistoryDetailDTO> list=new ArrayList<>();
        try {
            CarLoanMsgDTO dto=new CarLoanMsgDTO();
            List<CarLoanHistoryDetailDTO> carlist=new ArrayList<>();
            CarLoanMsgDTO carMagDto=new CarLoanMsgDTO();
            dto.setOrderNumber(orderNumber);
            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            List<CarLoanMsgDTO> dataList=msgService.searchCarLoanMsgs(searchParams);
            if(CollectionUtils.isNotEmpty(dataList)){
                String carNumber=dataList.get(0).getCarNumber();
                carMagDto.setCarNumber(carNumber);
                carMagDto.setOrderNumber(orderNumber);
                list=historyInfoService.queryCarNumber(carMagDto);
                for (int j = 0; j < list.size(); j++) {
                    list.get(j).setIsCarXin("1");
                }
            }
            result.setDataList(list);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("执行getCarNumber异常",e);
        }

        return result;
    }

    @RequestMapping(value = "/getCarIdCard",method = RequestMethod.POST)
    @ApiOperation(value="根据orderNumber查询身份证匹配订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    public ResponseResult<CarLoanHistoryDetailDTO> getCarIdCard(@RequestParam("orderNumber")String orderNumber) throws Exception {
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        List<CarLoanHistoryDetailDTO> list=new ArrayList<CarLoanHistoryDetailDTO>();
        CarLoanHistoryDetailDTO carLoanHistoryDetailDTO=new CarLoanHistoryDetailDTO();
        try {
            CarLoanUserDTO dto=new CarLoanUserDTO();
            CarLoanUserDTO carLoanUserDTO=new CarLoanUserDTO();
            dto.setOrderNumber(orderNumber);
            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            CarLoanUserDTO CarLoanUserDTO=userService.searchCarLoanUserByDetail(searchParams);
            if(CarLoanUserDTO!=null){
                String idCard= CarLoanUserDTO.getIdCard();
                carLoanUserDTO.setIdCard(idCard);
                carLoanUserDTO.setOrderNumber(orderNumber);
                List<CarLoanHistoryDetailDTO> phoneHistoryList=historyInfoService.queryCarLoanPhone(carLoanUserDTO);
                if(CollectionUtils.isNotEmpty(phoneHistoryList)){
                    for (int i = 0; i < phoneHistoryList.size(); i++) {
                        phoneHistoryList.get(i).setIsCarXin("1");
                    }
                    list.addAll(phoneHistoryList);
                }
                /*Map<String, String> map=new HashMap<>();
                map.put("idCard",idCard);
                try {
                    String carList= HttpUtil.sendPost("http://172.24.133.70:8080/loan/api/carLoanHistory/getLoanCarIdCard",map);
                    List<CarLoanHistoryDetailDTO> historyDetailList= JSONArray.parseArray(carList,CarLoanHistoryDetailDTO.class);
                    if(CollectionUtils.isNotEmpty(historyDetailList)){
                        list.addAll(historyDetailList);
                    }
                }catch (Exception a){
                    a.printStackTrace();
                    log.error("执行查询信审getCarIdCard异常",a);
                }*/
                carLoanHistoryDetailDTO.setIdCard(idCard);
            }
            result.setData(carLoanHistoryDetailDTO);
            result.setDataList(list);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("执行getCarIdCard异常",e);
        }
        return result;
    }

    @RequestMapping(value = "/getCarFrameNumbe",method = RequestMethod.POST)
    @ApiOperation(value="根据orderNumber查询车架号匹配订单信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    public ResponseResult<CarLoanHistoryDetailDTO> getCarFrameNumbe(@RequestParam("orderNumber")String orderNumber) throws Exception {
        ResponseResult<CarLoanHistoryDetailDTO> result=new ResponseResult<>();
        List<CarLoanHistoryDetailDTO> list=new ArrayList<>();
        try {
            CarLoanMsgDTO dto=new CarLoanMsgDTO();
            List<CarLoanHistoryDetailDTO> carlist=new ArrayList<>();
            CarLoanMsgDTO carMagDto=new CarLoanMsgDTO();
            dto.setOrderNumber(orderNumber);
            Map<String, Object> searchParams = new HashMap<String, Object>();
            searchParams.put("dto", dto);
            List<CarLoanMsgDTO> dataList= msgService.searchCarLoanMsgs(searchParams);
            if(CollectionUtils.isNotEmpty(dataList)){
                String carFrameNumber=dataList.get(0).getCarFrameNumber();
                carMagDto.setCarFrameNumber(carFrameNumber);
                carMagDto.setOrderNumber(orderNumber);
                list=historyInfoService.queryCarNumber(carMagDto);
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIsCarXin("1");
                }
            }
            result.setDataList(list);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("执行getCarFrameNumbe异常",e);
        }
        return result;
    }

    @RequestMapping(value = "/queryCarLoanOne",method = RequestMethod.POST)
    public CarLoanUserVo queryCarLoanOne(@RequestParam("orderNumber")String orderNumber) throws Exception {
        CarLoanUserDTO dto=new CarLoanUserDTO();
        dto.setOrderNumber(orderNumber);
        Map<String, Object> searchParams = new HashMap<String, Object>();
        searchParams.put("dto", dto);
        CarLoanUserDTO carLoanUserDTO=userService.searchCarLoanUserByDetail(searchParams);
        CarLoanUserVo carLoanUserVo=new CarLoanUserVo();
        carLoanUserVo.setIdCard(carLoanUserDTO.getIdCard());
        carLoanUserVo.setPhoneNumber(carLoanUserDTO.getPhoneNumber());
        return carLoanUserVo;
    }

}
