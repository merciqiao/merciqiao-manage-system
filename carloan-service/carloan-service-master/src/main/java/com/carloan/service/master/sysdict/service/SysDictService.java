
package com.carloan.service.master.sysdict.service;

import com.carloan.common.web.annotation.Page;
import com.carloan.service.master.sysdict.dao.SysDictDao;
import com.carloan.service.master.sysdict.dto.SysDictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @classname: SysDictService
 * @description: 定义  sys_dict 实现类
 * @author:  root
 */
@Service
public class SysDictService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysDictDao dao;

	public List<SysDictDTO> searchSysDictByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysDictDTO> dataList =  dao.searchSysDictByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysDict(SysDictDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysDictDTO> dataList = dao.searchSysDict(paramMap);
        return dataList;
    }
	public SysDictDTO querySysDictByPrimaryKey(String id) throws Exception {
		SysDictDTO dto = dao.findSysDictByPrimaryKey(id);
		if(dto == null) dto = new SysDictDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysDict(SysDictDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysDict(paramMap);
		SysDictDTO resultDto = (SysDictDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysDict(SysDictDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysDict(paramMap);
		}

    public SysDictDTO queryLikeSysDict(SysDictDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysDict(paramMap);
		}


	public int getCount(String dictCode){
		return this.dao.getCount(dictCode);
	}
}

