
package com.carloan.service.master.sysdictdetail.service;
import com.carloan.common.web.annotation.Page;
import com.carloan.service.master.sysdictdetail.dao.SysDictDetailDao;
import com.carloan.service.master.sysdictdetail.dto.SysDictDetailDTO;
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
 * @classname: SysDictDetailService
 * @description: 定义  sys_dict_detail 实现类
 * @author:  root
 */
@Service
public class SysDictDetailService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private SysDictDetailDao dao;

	public List<SysDictDetailDTO> searchSysDictDetailByPaging(Map<String,Object> searchParams) throws Exception {
		List<SysDictDetailDTO> dataList =  dao.searchSysDictDetailByPaging(searchParams);
		return dataList;
	}
	@Page
	public Object searchSysDictDetail(SysDictDetailDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<SysDictDetailDTO> dataList = dao.searchSysDictDetail(paramMap);
        return dataList;
    }
	public SysDictDetailDTO querySysDictDetailByPrimaryKey(String id) throws Exception {
		SysDictDetailDTO dto = dao.findSysDictDetailByPrimaryKey(id);
		if(dto == null) dto = new SysDictDetailDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public Long insertSysDictDetail(SysDictDetailDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertSysDictDetail(paramMap);
		SysDictDetailDTO resultDto = (SysDictDetailDTO) paramMap.get("dto");
		Long keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateSysDictDetail(SysDictDetailDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateSysDictDetail(paramMap);
		}

    public SysDictDetailDTO queryLikeSysDictDetail(SysDictDetailDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeSysDictDetail(paramMap);
		}

	public List<SysDictDetailDTO> searchCodeSysDictDetail(String code){
		return this.dao.searchCodeSysDictDetail(code);
	}


}

