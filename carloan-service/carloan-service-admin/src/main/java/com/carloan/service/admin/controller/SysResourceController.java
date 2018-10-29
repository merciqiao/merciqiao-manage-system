package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysResourceParam;
import com.carloan.api.model.admin.SysResourceVo;
import com.carloan.api.model.admin.TreeNodeVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
//import com.carloan.feign.admin.SysResourceServicefeign;
import com.carloan.service.admin.rest.SysResourceRest;
import com.carloan.service.admin.sysresource.dto.SysResourceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 此接口为外部提供调用,通过注册中心获取相关业务接口标识，通过[feign]rest形式调用服务方接口
 */

@RestController
@RequestMapping(value = "sysResource_api")
@Slf4j
@Api(tags = {"资源管理接口-hanxiaoyan"})
public class SysResourceController {


    @Autowired
    private SysResourceRest feiservice;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysResourceByPrimaryKey", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysResourceDTO> querySysResourceByPrimaryKey(@RequestParam("ID") String ID) throws Exception {
        ResponseResult<SysResourceDTO> result = new ResponseResult<>();
        try {
            return feiservice.querySysResourceByPrimaryKey(ID);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

    /**
     * 取得List业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getSysResourceList", method = RequestMethod.POST)
    @ApiOperation(value = "查询返回List对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<TreeNodeVo>> querySysResourceList(@RequestBody SysResourceParam obj) throws Exception {
        ResponseResult<List<SysResourceDTO>> result = new ResponseResult<>();
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {
            result= feiservice.querySysResourceList(obj);
            resulttree.setData(this.ToTreeModel(result.getData()));
            resulttree.setStatus(result.getStatus());
            return resulttree;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return resulttree;

        }
    }
    public  List<TreeNodeVo> ToTreeModel(List<SysResourceDTO> list)
    {
        List<TreeNodeVo> treelist=new ArrayList<>();
        for (SysResourceDTO vo:list) {
            TreeNodeVo treenode=new TreeNodeVo();
            treenode.setId(vo.getId().toString());
            treenode.setName(vo.getResoureName());
            treenode.setParentId(vo.getParentId());
            treelist.add(treenode);
        }
        return TreeNodeVo.treeBuild(treelist);

    }

    /**
     * 根据对象查询信息返回单个实体
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryLike", method = RequestMethod.POST)
    @ApiOperation(value = "查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysResourceDTO> queryLike(@RequestBody SysResourceDTO obj) throws Exception {
        ResponseResult<SysResourceDTO> result = new ResponseResult<>();
        try {
            return feiservice.queryLike(obj);
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
    @RequestMapping(value = "/saveSysResource", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysResource(@RequestBody SysResourceDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            obj.setValidateState("1");
            obj.setVersion((long)1);
            if(obj!=null&&obj.getId()>0) {
                return feiservice.update(obj);
            }
            else {
                return feiservice.create(obj);
            }
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
    @RequestMapping(value = "/Web/update/v1", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult updateSysResource(@RequestBody SysResourceDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            return feiservice.update(obj);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;
        }
    }
    @ApiOperation(value="根据主键id删除资源数据",notes="返回结果,SUCCESS:100,FAILED:200",httpMethod = "POST")
    @RequestMapping(value = "/deleteResourceByID",method = RequestMethod.POST)
    public ResponseResult deleteResourceByID(@RequestParam("") String orgid)throws Exception {
        ResponseResult result = new ResponseResult<>();
        try {
            return feiservice.deleteResourceByID(orgid);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            result.setStatus(Status.FAILED);
            result.setMessage("执行异常,请重试");
            return result;

        }
    }

}