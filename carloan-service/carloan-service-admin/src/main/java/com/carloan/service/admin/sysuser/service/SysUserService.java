
package com.carloan.service.admin.sysuser.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysUserParam;
import com.carloan.common.web.annotation.Page;
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


}

