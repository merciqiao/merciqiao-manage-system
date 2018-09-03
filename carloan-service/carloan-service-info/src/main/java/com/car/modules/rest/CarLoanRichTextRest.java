package com.car.modules.rest;

import com.car.modules.loan.carloanrichtext.dto.CarLoanRichTextDTO;
import com.car.modules.loan.carloanrichtext.service.CarLoanRichTextService;
import com.carloan.apimodel.common.Response;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value="/carloanrichtext-api")
@Slf4j
@Component
@Api(tags="初审备注以及终审备注rest")
public class CarLoanRichTextRest {
    @Autowired
    private CarLoanRichTextService service;
    @Autowired
    Mapper mapper;
    @ApiOperation(value="查询初审备注以及终审备注信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/searchCarLoanRichText",method = RequestMethod.POST)
    public ResponseResult<CarLoanRichTextDTO> searchCarLoanRichText(@RequestParam("relation_number") String relation_number,@RequestParam("biz_type") String biz_type) throws Exception {
        ResponseResult<CarLoanRichTextDTO> result = new ResponseResult<>();
        try {
            CarLoanRichTextDTO carLoanRichText = this.service.queryCarLoanRichTextByNum(relation_number,biz_type);
            result.setData(carLoanRichText);
            result.setStatus(Status.SUCCESS);
            result.setMessage("查询成功！");
            return result;
        }catch(Exception ex)
        {
            log.error("执行方法CarLoanRichTextController：searchCarLoanRichText"+ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="新增或者编辑初审终审备注信息",notes="返回结果,SUCCESS:200,FAILED:500",httpMethod = "POST")
    @RequestMapping(value = "/insertCarLoanRichText",method = RequestMethod.POST)
    public Response insertCarLoanRichText(@RequestParam("relation_number") String relation_number,@RequestParam("biz_type") String biz_type,@RequestParam("Content") String Content) throws Exception {
        Response result=new Response();
        try {
            CarLoanRichTextDTO queryDTO = new CarLoanRichTextDTO();
            queryDTO = this.service.queryCarLoanRichTextByNum(relation_number, biz_type);
            if (queryDTO == null || queryDTO.equals("")) {
                CarLoanRichTextDTO csDTO = new CarLoanRichTextDTO();
                csDTO.setRelationNumber(relation_number);
                csDTO.setBizType(biz_type);
                csDTO.setContent(Content);
                csDTO.setCreationTime(new Date());
                this.service.insertCarLoanRichText(csDTO);
            } else {
                queryDTO.setContent(Content);
                this.service.updateCarLoanRichText(queryDTO);
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
