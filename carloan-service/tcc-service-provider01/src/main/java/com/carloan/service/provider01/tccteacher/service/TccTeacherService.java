
package com.carloan.service.provider01.tccteacher.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.provider01.tccteacher.dto.TccTeacherDTO;
import com.carloan.service.provider01.tccteacher.dao.TccTeacherDao;
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
 * @classname: TccTeacherService
 * @description: 定义  tcc_teacher 实现类
 * @author:  root
 */
@Service
public class TccTeacherService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private TccTeacherDao dao;

	public List<TccTeacherDTO> searchTccTeacherByPaging(Map<String,Object> searchParams) throws Exception {
		List<TccTeacherDTO> dataList =  dao.searchTccTeacherByPaging(searchParams);
		return dataList;
	}
	public List<TccTeacherDTO> searchTccTeacher(TccTeacherDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<TccTeacherDTO> dataList = dao.searchTccTeacher(paramMap);
        return dataList;
    }
	public TccTeacherDTO queryTccTeacherByPrimaryKey(String id) throws Exception {
		TccTeacherDTO dto = dao.findTccTeacherByPrimaryKey(id);
		if(dto == null) dto = new TccTeacherDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public int insertTccTeacher(TccTeacherDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertTccTeacher(paramMap);
		TccTeacherDTO resultDto = (TccTeacherDTO) paramMap.get("dto");
		int keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateTccTeacher(TccTeacherDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateTccTeacher(paramMap);
		}

    public TccTeacherDTO queryLikeTccTeacher(TccTeacherDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeTccTeacher(paramMap);
		}

}

