
package com.carloan.service.admin.sysuser.service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysUserParam;
import com.carloan.apimodel.shiro.LoginInfoVo;
import com.carloan.apimodel.shiro.RolePermissionVo;
import com.carloan.apimodel.shiro.SysMenuVo;
import com.carloan.apimodel.shiro.SysRoleVo;
import com.carloan.common.utils.MapperUtil;
import com.carloan.common.web.annotation.Page;
import com.carloan.service.admin.sysmenu.dto.SysMenuDTO;
import com.carloan.service.admin.sysmenu.service.SysMenuService;
import com.carloan.service.admin.sysresource.dto.SysResourceDTO;
import com.carloan.service.admin.sysresource.service.SysResourceService;
import com.carloan.service.admin.sysrole.dto.SysRoleDTO;
import com.carloan.service.admin.sysrole.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysuser.dto.SysUserDTO;
import com.carloan.service.admin.sysuser.dao.SysUserDao;
 /*
                           _ooOoo_
                          o8888888o
                          88" . "88
                          (| -_- |)
                          O\  =  /O
                       ____/`---'\____
                     .'  \\|     |//  `.
                    /  \\|||  :  |||//  \
                   /  _||||| -:- |||||-  \
                   |   | \\\  -  /// |   |
                   | \_|  ''\---/''  |   |
                   \  .-\__  `-`  ___/-. /
                 ___`. .'  /--.--\  `. . __
              ."" '<  `.___\_<|>_/___.'  >'"".
             | | :  `- \`.;`\ _ /`;.`/ - ` : | |
             \  \ `-.   \_ __\ /__ _/   .-` /  /
        ======`-.____`-.___\_____/___.-`____.-'======
                           `=---='
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                 佛祖保佑       永无BUG
 */
/**
 * @classname: SysUserService
 * @description: 定义  sys_user 实现类
 * @author:  root
 */
@Service
public class SysUserService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysUserDao dao;
	@Autowired
	MapperUtil mapperUtil;
	@Autowired
	SysRoleService sysRoleService;
	@Autowired
	SysResourceService sysResourceService;
	@Autowired
	SysMenuService sysMenuService;

	public List<SysUserDTO> searchSysUserByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysUserDTO> dataList =  dao.searchSysUserByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysUser(SysUserParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysUserDTO> dataList = dao.searchSysUser(paramMap);
        return dataList;
    }
	public SysUserDTO querySysUserByPrimaryKey(String id) throws Exception {
		SysUserDTO dto = dao.findSysUserByPrimaryKey(id);
		if(dto == null) dto = new SysUserDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysUser(SysUserDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysUser(paramMap);
		SysUserDTO resultDto = (SysUserDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysUser(SysUserDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysUser(paramMap);
		}
	public void deleteSysUserByPrimaryKey(String ids)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("ids",ids);
		dao.deleteSysUserByPrimaryKey(paramMap);
	}

    public SysUserDTO queryLikeSysUser(SysUserDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysUser(paramMap);
		}

	/**
	 * 根据username查userinfo
	 * @param dto
	 * @return
	 */
	public SysUserDTO getUserInfoByLoginName(SysUserDTO dto) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);

		return dao.getUserInfoByLoginName(paramMap);
	}
	/**
	 * 返回登陆信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public LoginInfoVo getLoginInfoByUserId(String userId) throws Exception{
		LoginInfoVo loginInfoVo=new LoginInfoVo();

		List<SysRoleDTO> sysRoleDTOList=this.GetSysRoleByUserId(userId);
		List<SysResourceDTO> sysResourceDTOList=this.GetPermission(userId);
		List<SysMenuDTO> sysMenuDTOList=this.GetSysMenuByUserId(userId);

		List<SysRoleVo> sysRoleVoList= mapperUtil.map(sysRoleDTOList,SysRoleVo.class) ;
		List<RolePermissionVo> rolePermissionVoList= mapperUtil.map(sysResourceDTOList,RolePermissionVo.class);
		List<SysMenuVo> sysMenuVoList=mapperUtil.map(sysMenuDTOList,SysMenuVo.class);
		sysMenuVoList=this.convertSysMenuVo(sysMenuVoList);
		loginInfoVo.setSysRoleVoList(sysRoleVoList);
		loginInfoVo.setRolePermissionVoList(rolePermissionVoList);
		loginInfoVo.setSysMenuVoList(sysMenuVoList);
		return loginInfoVo;
	}
	/**
	 * 根据用户id查询用户角色集合
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<SysRoleDTO> GetSysRoleByUserId(String userId) throws Exception{
		SysRoleDTO sysRoleParam=new SysRoleDTO();
		sysRoleParam.setTarget_id(Long.parseLong(userId));
		List<SysRoleDTO> sysRoleDTOList= sysRoleService.selectSysRoleByUserId(sysRoleParam);
		return sysRoleDTOList;
	}
	/**
	 * 根据用户id查询用户的按钮权限,用于按钮的显示和隐藏
	 * @param userId
	 * @return
	 */
	private List<SysResourceDTO> GetPermission(String userId) throws Exception{
		SysResourceDTO rolePermissionParam=new SysResourceDTO();
		rolePermissionParam.setUserId(Long.parseLong(userId));
		rolePermissionParam.setResoureType("button");
		List<SysResourceDTO> sysResourceDTOList= sysResourceService.selectShiroUrlPermissionByUserId(rolePermissionParam);
		return sysResourceDTOList;
	}
	/**
	 * 根据userid查询菜单信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private List<SysMenuDTO> GetSysMenuByUserId(String userId) throws Exception{
		List<SysMenuDTO> sysMenuDTOList =sysMenuService.querySysMenuByUserId(userId);
		return sysMenuDTOList;
	}
	/**
	 * 转换菜单为 菜单树
	 * @param sysMenuSourceList
	 * @return
	 * @throws Exception
	 */
	private List<SysMenuVo> convertSysMenuVo(List<SysMenuVo> sysMenuSourceList)throws Exception{
		//查询一级菜单,parentId=0的
		List<SysMenuVo> roots=this.searchMenuByParentId(sysMenuSourceList,"0");

		this.convertSysMenuVo(roots,sysMenuSourceList);
		return roots;
	}
	private void convertSysMenuVo(List<SysMenuVo> roots,List<SysMenuVo> sysMenuSourceList){
		//遍历一级菜单
		for(SysMenuVo root :roots){
			String id=root.getId().toString();
			List<SysMenuVo> childs=this.searchMenuByParentId(sysMenuSourceList,id);
			root.setSysMenuVoChild(childs);
			convertSysMenuVo(childs,sysMenuSourceList);
		}
	}
	/**
	 * 根据parentid查询子节点
	 * @param sysMenuVoList
	 * @param parentId
	 * @return
	 */
	private List<SysMenuVo> searchMenuByParentId(List<SysMenuVo> sysMenuVoList,String parentId){
		List<SysMenuVo> childs=new ArrayList<>();
		for(SysMenuVo sysMenuVo:sysMenuVoList){
			if(sysMenuVo.getParentId().equals(parentId)){
				childs.add(sysMenuVo);
			}
		}
		return childs;
	}
}

