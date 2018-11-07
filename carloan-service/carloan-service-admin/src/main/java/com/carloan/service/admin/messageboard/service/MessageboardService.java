package com.carloan.service.admin.messageboard.service;

import com.carloan.service.admin.messageboard.dao.MessageboardDao;
import com.carloan.service.admin.messageboard.vo.MessageboardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageboardService")
public class MessageboardService {
	@Autowired
	private MessageboardDao messageboardDao;
	
	public void	 queryObject(Integer id){
	 	MessageboardVO vo=messageboardDao.queryObject(id);

	}

}
