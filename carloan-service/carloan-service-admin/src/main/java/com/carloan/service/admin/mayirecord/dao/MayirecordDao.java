package com.carloan.service.admin.mayirecord.dao;

import com.carloan.service.admin.mayirecord.entity.MayirecordEntity;
import com.carloan.service.admin.mayirecord.entity.MayirecordListEntity;
import com.carloan.service.admin.mayirecord.vo.MayirecordVO;
import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */

public interface MayirecordDao  {

	public MayirecordVO queryObject(Integer id);

	public List<MayirecordVO> queryList(MayirecordListEntity mayirecord);
	
	public int queryTotal(MayirecordListEntity mayirecord);
	
	public void save(MayirecordEntity mayirecord);
	
	public void update(MayirecordEntity mayirecord);
	
	public void delete(Integer id);
	
	public void deleteBatch(Integer[] ids);
	
}
