package com.carloan.service.admin.mayi.dao;

import com.carloan.service.admin.mayi.entity.MayiEntity;
import com.carloan.service.admin.mayi.entity.MayiListEntity;
import com.carloan.service.admin.mayi.vo.MayiVO;

import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:35:17
 */

public interface MayiDao  {

	public MayiVO queryObject(String ip);

	public List<MayiVO> queryList(MayiEntity mayi);
	
	public int queryTotal(MayiListEntity mayi);
	
	public void save(MayiEntity mayi);
	
	public void update(MayiEntity mayi);
	
	public void delete(Integer id);
	
	public void deleteBatch(Integer[] ids);
	
}
