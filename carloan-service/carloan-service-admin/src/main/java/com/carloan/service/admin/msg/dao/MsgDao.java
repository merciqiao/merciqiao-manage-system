package com.carloan.service.admin.msg.dao;

import com.carloan.service.admin.msg.entity.MsgEntity;
import com.carloan.service.admin.msg.entity.MsgListEntity;
import com.carloan.service.admin.msg.vo.MsgVO;
import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-12-15 22:29:54
 */

public interface MsgDao  {

	public MsgVO queryObject(Integer id);

	public List<MsgVO> queryList(MsgEntity msg);
	
	public int queryTotal(MsgListEntity msg);
	
	public void save(MsgEntity msg);
	
	public void update(MsgEntity msg);
	
	public void delete(Integer id);
	
	public void deleteBatch(Integer[] ids);
	
}
