
package com.carloan.service.provider02.tcccourse.service;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.carloan.service.provider02.tcccourse.dto.TccCourseDTO;
import com.carloan.service.provider02.tcccourse.dao.TccCourseDao;

/**
 * @classname: TccCourseService
 * @description: 定义  tcc_course 实现类
 * @author:  root
 */
@Service
public class TccCourseService implements Serializable {

    private static final long serialVersionUID = 1L;

	@Autowired
	private TccCourseDao dao;

	public List<TccCourseDTO> searchTccCourseByPaging(Map<String,Object> searchParams) throws Exception {
		List<TccCourseDTO> dataList =  dao.searchTccCourseByPaging(searchParams);
		return dataList;
	}
	public List<TccCourseDTO> searchTccCourse(TccCourseDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
	    List<TccCourseDTO> dataList = dao.searchTccCourse(paramMap);
        return dataList;
    }
	public TccCourseDTO queryTccCourseByPrimaryKey(String id) throws Exception {
		TccCourseDTO dto = dao.findTccCourseByPrimaryKey(id);
		if(dto == null) dto = new TccCourseDTO();
		return dto;

	}

	@SuppressWarnings("all")
	@Transactional(rollbackFor = {Exception.class})
	public int insertTccCourse(TccCourseDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		int count = dao.insertTccCourse(paramMap);
		TccCourseDTO resultDto = (TccCourseDTO) paramMap.get("dto");
		int keyId = resultDto.getId();
		return keyId;
	}
    @Transactional(rollbackFor = {Exception.class})
    public void updateTccCourse(TccCourseDTO dto)throws Exception{
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("dto",dto);
		dao.updateTccCourse(paramMap);
		}

    public TccCourseDTO queryLikeTccCourse(TccCourseDTO dto) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dto", dto);
		return dao.queryLikeTccCourse(paramMap);
		}

}

