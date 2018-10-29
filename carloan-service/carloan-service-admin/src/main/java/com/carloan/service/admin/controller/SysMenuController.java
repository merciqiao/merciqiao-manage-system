package com.carloan.service.admin.controller;

import com.carloan.api.model.admin.SysMenuParam;
import com.carloan.api.model.admin.SysMenuVo;
import com.carloan.api.model.admin.TreeNodeVo;
import com.carloan.apimodel.common.ResponseResult;
import com.carloan.apimodel.common.Status;
//import com.carloan.feign.admin.SysMenuServicefeign;
import com.carloan.service.admin.rest.SysMenuRest;
import com.carloan.service.admin.sysmenu.dto.SysMenuDTO;
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
@RequestMapping(value = "sysMenu-api")
@Slf4j
public class SysMenuController {


    @Autowired
    private SysMenuRest feiservice;


    /**
     * 取得单个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/querySysMenuByPrimaryKey", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysMenuDTO> querySysMenuByPrimaryKey(@RequestParam("ID") String ID) throws Exception {
        ResponseResult<SysMenuDTO> result = new ResponseResult<>();
        try {
            return feiservice.querySysMenuByPrimaryKey(ID);
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
    @RequestMapping(value = "/querySysMenuList", method = RequestMethod.POST)
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<List<TreeNodeVo>> querySysMenuList(@RequestBody SysMenuParam obj) throws Exception {
        ResponseResult<List<SysMenuDTO>> result = new ResponseResult<>();
        ResponseResult<List<TreeNodeVo>> resulttree = new ResponseResult<>();
        try {
            result= feiservice.querySysMenuList(obj);
            resulttree.setData(this.ToTreeModel(result.getData()));
            resulttree.setStatus(result.getStatus());
            return resulttree;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            resulttree.setStatus(Status.FAILED);
            resulttree.setMessage("执行异常,请重试");
            return resulttree;

        }
    }
    public  List<TreeNodeVo> ToTreeModel(List<SysMenuDTO> list)
    {
        List<TreeNodeVo> treelist=new ArrayList<>();
        for (SysMenuDTO vo:list) {
            TreeNodeVo treenode=new TreeNodeVo();
            treenode.setId(vo.getId().toString());
            treenode.setName(vo.getMenuName());
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
    @ApiOperation(value = "根据ID 查询返回对象", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult<SysMenuDTO> queryLike(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult<SysMenuDTO> result = new ResponseResult<>();
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
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "新增对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult insertSysMenu(@RequestBody SysMenuDTO obj) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            if(obj!=null&& obj.getId()>0)
            {
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
    @RequestMapping(value = "/updateSysMenu", method = RequestMethod.POST)
    @ApiOperation(value = "修改对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult updateSysMenu(@RequestBody SysMenuDTO obj) throws Exception {
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
    /**
     * 删除一个业务对象
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteSysMenu", method = RequestMethod.POST)
    @ApiOperation(value = "删除对象数据", notes = "返回结果,SUCCESS:200,FAILED:500", httpMethod = "POST")
    public ResponseResult deleteSysMenu(@RequestParam("ids") String ids) throws Exception {
        ResponseResult result = new ResponseResult();
        try {

            if(ids!=null&&!ids.equals(""))
            {
                feiservice.deleteSysMenu(ids);
                result.setStatus(Status.SUCCESS);
                result.setMessage("删除成功");
            }
            else
            {
                result.setStatus(Status.FAILED);
                result.setMessage("删除失败");
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