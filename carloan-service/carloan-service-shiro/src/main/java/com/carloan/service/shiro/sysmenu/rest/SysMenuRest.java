package com.carloan.service.shiro.sysmenu.rest;

import java.util.List;


import com.carloan.apimodel.shiro.SysMenuVo;
import com.carloan.common.utils.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
import io.swagger.annotations.ApiOperation;
import com.carloan.service.shiro.sysmenu.dto.SysMenuDTO;
import com.carloan.service.shiro.sysmenu.service.SysMenuService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * 定义rest接口
 */

@RestController
@RequestMapping(value = "/api/sysMenu")
@Slf4j
@Api(tags = {"sys_menu"})
public class SysMenuRest {


    @Autowired
    private SysMenuService service;
    @Autowired
    MapperUtil mapperUtil;

    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/get/v1/{ID}", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysMenuDTO> querySysMenuByPrimaryKey(@PathVariable("ID") String ID) throws Exception {
        ResponseResult<SysMenuDTO> result = new ResponseResult<>();
        try {
            SysMenuDTO entity = service.querySysMenuByPrimaryKey(ID);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


    /**
     * 取得List对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSysMenuList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<SysMenuDTO>> querySysMenuList(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult<List<SysMenuDTO>> result = new ResponseResult<>();
        try {
            List<SysMenuDTO> entity = service.searchSysMenu(obj);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }


    /**
     * 根据对象查询信息返回单个实体
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryLike", method = RequestMethod.POST)
    @ApiOperation(value = "根据对象信息查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysMenuDTO> queryLike(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult<SysMenuDTO> result = new ResponseResult<>();
        try {
            SysMenuDTO entity = service.queryLikeSysMenu(obj);
            result.setStatus(Status.SUCCESS);
            result.setData(entity);
            result.setMessage("查询成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 插入一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create/v1", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult create(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.insertSysMenu(obj);
            result.setStatus(Status.SUCCESS);
            result.setMessage("新增成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 修改一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult update(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            service.updateSysMenu(obj);
            result.setStatus(Status.SUCCESS);
            result.setMessage("修改成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    /**
     * 修改一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete/v1", method = RequestMethod.POST)
    @ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult deleteSysMenu(@RequestParam("ids") String ids) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            if(ids!=null&&!ids.equals(""))
            {
                service.deleteSysMenu(ids);
                result.setStatus(Status.SUCCESS);
                result.setMessage("修改成功");
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("修改失败");
            }
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    /**
     * 根据userId查询用户菜单集合
     *
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "根据userId查询用户菜单集合", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    @RequestMapping(value = "/querySysMenuByUserId", method = RequestMethod.POST)
    public ResponseResult<SysMenuVo> querySysMenuByUserId(@RequestParam String userId) throws Exception {
        ResponseResult<SysMenuVo> result = new ResponseResult();
        try {
            List<SysMenuDTO> sysMenuDTOList= service.querySysMenuByUserId(userId);
            List<SysMenuVo> sysMenuVoList=mapperUtil.map(sysMenuDTOList,SysMenuVo.class);
            result.setDataList(sysMenuVoList);
            result.setStatus(Status.SUCCESS);
            result.setMessage("执行成功");
            return result;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }

}