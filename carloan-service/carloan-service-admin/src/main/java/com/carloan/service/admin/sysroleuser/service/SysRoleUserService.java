
package com.carloan.service.admin.sysroleuser.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.carloan.api.model.admin.SysRoleUserParam;
import com.carloan.common.web.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.admin.sysroleuser.dto.SysRoleUserDTO;
import com.carloan.service.admin.sysroleuser.dao.SysRoleUserDao;
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
 * @classname: SysRoleUserService
 * @description: 定义  sys_role_user 实现类
 * @author:  root
 */
@Service
public class SysRoleUserService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysRoleUserDao dao;

	public List<SysRoleUserDTO> searchSysRoleUserByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysRoleUserDTO> dataList =  dao.searchSysRoleUserByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysRoleUser(SysRoleUserParam dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysRoleUserDTO> dataList = dao.searchSysRoleUser(paramMap);
        return dataList;
    }
	public SysRoleUserDTO querySysRoleUserByPrimaryKey(String id) throws Exception {
		SysRoleUserDTO dto = dao.findSysRoleUserByPrimaryKey(id);
		if(dto == null) dto = new SysRoleUserDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysRoleUser(SysRoleUserDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysRoleUser(paramMap);
		SysRoleUserDTO resultDto = (SysRoleUserDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysRoleUser(SysRoleUserDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysRoleUser(paramMap);
		}

    public SysRoleUserDTO queryLikeSysRoleUser(SysRoleUserDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysRoleUser(paramMap);
		}
	public boolean deleteSysRoleUserbyID(String id) throws Exception {
		int count = dao.deleteSysRoleUserbyID(id);
		if(count>0) {
			return true;
		}
		else {
			return false;
		}
	}

}

