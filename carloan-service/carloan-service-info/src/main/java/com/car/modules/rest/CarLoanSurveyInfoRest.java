package com.car.modules.rest;

import com.car.modules.loan.carloanrichtext.dto.CarLoanRichTextDTO;
import com.car.modules.loan.carloanrichtext.service.CarLoanRichTextService;
import com.car.modules.loan.carloansurveyinfo.dto.CarLoanSurveyInfoDTO;
import com.car.modules.loan.carloansurveyinfo.service.CarLoanSurveyInfoService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value="/carloansurveyinfo-api")
@Slf4j
@Component
@Api(tags="电核备注rest")
public class CarLoanSurveyInfoRest {
    @Autowired
    private CarLoanSurveyInfoService service;
    @Autowired
    private CarLoanRichTextService carLoanRichTextService;
    @Autowired
    Mapper mapper;

    @ApiOperation(value="查询电核网核备注信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanSurveyInfo",method = RequestMethod.POST)
    public ResponseResult<CarLoanSurveyInfoDTO> searchCarLoanSurveyInfo(@RequestParam("survey_contacts_id") String survey_contacts_id) throws Exception {
        ResponseResult<CarLoanSurveyInfoDTO> result = new ResponseResult<>();
        try {
           CarLoanSurveyInfoDTO carLoanSurveyInfo = this.service.queryCarLoanSurveyInfoBySurveyContactsId(survey_contacts_id);
            result.setData(carLoanSurveyInfo);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功！");
            return result;
        }catch(Exception ex)
        {
            log.error("执行方法CarLoanSurveyInfoController：searchCarLoanSurveyInfo"+ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="新增电核网核备注信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanSurveyInfo",method = RequestMethod.POST)
    public Response insertCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) throws Exception {
        Response result=new Response();
        try {
            CarLoanSurveyInfoDTO dto=mapper.map(carLoanSurveyInfoParam,CarLoanSurveyInfoDTO.class);
            dto.setCreateTime(new Date());
            dto.setUpdateTime(new Date());
            this.service.insertCarLoanSurveyInfo(dto);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="更新电核网核备注信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/updateCarLoanSurveyInfo",method = RequestMethod.POST)
    public Response updateCarLoanSurveyContacts(@RequestBody CarLoanSurveyInfoDTO carLoanSurveyInfoParam) throws Exception {
        Response result=new Response();
        try {
            CarLoanSurveyInfoDTO dto=mapper.map(carLoanSurveyInfoParam,CarLoanSurveyInfoDTO.class);
            dto.setUpdateTime(new Date());
            this.service.updateCarLoanSurveyInfo(dto);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }

    }
    @ApiOperation(value="保存电核网核信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/saveCarLoanSurveyInfo",method = RequestMethod.POST)
    public Response saveCarLoanSurveyInfo(@RequestParam("order_number") String order_number,@RequestParam("otherRemark") String otherRemark,@RequestParam("contactsInfo_id") String contactsInfo_id,@RequestParam("ycContent") String ycContent) throws Exception {
        Response result=new Response();
        try {
             //新增或者编辑电核备注
            if(otherRemark.equals("null")) {
            }else {
                if (order_number != "" && otherRemark != "" && contactsInfo_id != "") {
                    CarLoanSurveyInfoDTO queryDTO = new CarLoanSurveyInfoDTO();
                    queryDTO = service.queryCarLoanSurveyInfoByOrderNumber(order_number, contactsInfo_id);
                    if (queryDTO == null || queryDTO.equals("")) {
                        CarLoanSurveyInfoDTO dto = new CarLoanSurveyInfoDTO();
                        dto.setOrderNumber(order_number);
                        dto.setSurveyContactsId(contactsInfo_id);
                        dto.setOtherRemark(otherRemark);
                        dto.setCreateTime(new Date());
                        dto.setUpdateTime(new Date());
                        this.service.insertCarLoanSurveyInfo(dto);
                    } else {
                        queryDTO.setOtherRemark(otherRemark);
                        queryDTO.setUpdateTime(new Date());
                        this.service.updateCarLoanSurveyInfo(queryDTO);
                    }
                }
            }
            //新增或者编辑异常备注
            if(ycContent.equals("null")) {
            }else {
                if (order_number != "" && ycContent != "") {
                    CarLoanRichTextDTO queryZSDTO = new CarLoanRichTextDTO();
                    queryZSDTO = carLoanRichTextService.queryCarLoanRichTextByNum(order_number, "NET_CHECK_THREEAUDIT_REMARK");
                    if (queryZSDTO == null || queryZSDTO.equals("")) {
                        CarLoanRichTextDTO ycDTO = new CarLoanRichTextDTO();
                        ycDTO.setRelationNumber(order_number);
                        ycDTO.setBizType("NET_CHECK_THREEAUDIT_REMARK");
                        ycDTO.setContent(ycContent);
                        ycDTO.setCreationTime(new Date());
                        this.carLoanRichTextService.insertCarLoanRichText(ycDTO);
                    } else {
                        queryZSDTO.setContent(ycContent);
                        this.carLoanRichTextService.updateCarLoanRichText(queryZSDTO);
                    }
                }
            }
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
            return result;
        }
        catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }


}
