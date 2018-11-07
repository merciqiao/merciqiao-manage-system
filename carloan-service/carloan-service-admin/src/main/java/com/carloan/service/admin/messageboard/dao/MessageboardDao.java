package com.carloan.service.admin.messageboard.dao;

import com.carloan.service.admin.messageboard.entity.MessageboardEntity;
import com.carloan.service.admin.messageboard.entity.MessageboardListEntity;
import com.carloan.service.admin.messageboard.vo.MessageboardVO;
import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-04 16:20:40
 */

public interface MessageboardDao  {

	public MessageboardVO queryObject(Integer id);

	public List<MessageboardVO> queryList(MessageboardListEntity messageboard);
	
	public int queryTotal(MessageboardListEntity messageboard);
	
	public void save(MessageboardEntity messageboard);
	
	public void update(MessageboardEntity messageboard);
	
	public void delete(Integer id);
	
	public void deleteBatch(Integer[] ids);
	
}
