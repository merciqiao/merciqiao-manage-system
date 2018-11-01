package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysPositionParam;
import com.carloan.api.model.admin.SysPositionVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
//import com.carloan.feign.admin.SysPositionServicefeign;
import com.carloan.service.admin.rest.SysPositionRest;
import com.carloan.service.admin.sysposition.dto.SysPositionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/sysPosition")
@Slf4j
@Api(tags="岗位管理")
public class SysPositionController {
    @Autowired
    private SysPositionRest sysPositionServicefeign;
    /**
     * 取得单个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Web/get/v1/{ID}", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysPositionDTO> querySysPositionByPrimaryKey(@RequestParam("ID") String ID)throws Exception{
        ResponseResult<SysPositionDTO>result=new ResponseResult<>();
        try{
            return sysPositionServicefeign.querySysPositionByPrimaryKey(ID);
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得List业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Web/getSysPositionList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public Object querySysPositionList(@RequestBody SysPositionParam obj)throws Exception{
        Object result=new ResponseResult<>();
        try{
            result= sysPositionServicefeign.querySysPositionList(obj);

            return result;
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);

            return result;

        }
    }


    /**
     * 根据对象查询信息返回单个实体
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Web/queryLike", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysPositionDTO> queryLike(@RequestBody SysPositionDTO obj)throws Exception{
        ResponseResult<SysPositionDTO>result=new ResponseResult<>();
        try{
            return sysPositionServicefeign.queryLike(obj);
        }catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }



    /**
     * 插入一个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Web/create/v1", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysPosition(@RequestBody SysPositionDTO obj)throws Exception{
        ResponseResult result=new ResponseResult();
        try{
            return sysPositionServicefeign.create(obj);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
    /**
     * 修改一个业务对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult updateSysPosition(@RequestBody SysPositionDTO obj)throws Exception{
        ResponseResult result=new ResponseResult();
        try{
            return sysPositionServicefeign.update(obj);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

    @ApiOperation(value="删除用户列表中用户",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteSysPositionById",method = RequestMethod.POST)
    public ResponseResult<Object> deleteSysPositionById2(@RequestParam("ids") String ids)throws Exception {
        ResponseResult<Object> result = new ResponseResult<>();
        try {


            if(ids!=null&&!ids.equals(""))
            {
                sysPositionServicefeign.deleteSysPositionById(ids);
                result.setMessage("删除成功");
                result.setStatus(Status.SUCCESS);
            }
            else
            {
                result.setMessage("删除失败");
                result.setStatus(Status.FAILED);
            }
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }
}
