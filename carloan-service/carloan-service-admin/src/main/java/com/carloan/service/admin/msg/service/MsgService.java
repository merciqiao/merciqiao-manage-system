package com.carloan.service.admin.msg.service;

import com.carloan.common.web.annotation.Page;
import com.carloan.service.admin.msg.dao.MsgDao;
import com.carloan.service.admin.msg.entity.MsgEntity;
import com.carloan.service.admin.msg.entity.MsgListEntity;

import com.carloan.service.admin.msg.vo.MsgVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-12-15 22:29:54
 */
@Service
public class MsgService {
	@Autowired
	MsgDao msgDao;
	
	//int deleteBatch(Integer[] ids);


	public MsgVO queryObject(int id){
		MsgVO vo=msgDao.queryObject(id);
		return vo;
	}

	@Page
	public Object queryList(MsgEntity mayi){

		return msgDao.queryList(mayi);
	}

	public Boolean save(MsgEntity mayi){
		msgDao.save(mayi);
		return true;
	}
	public Boolean update(MsgEntity mayi){
		msgDao.update(mayi);
		return true;
	}
	public Boolean delete(MsgEntity mayi){
		msgDao.delete(mayi.getId());
		return true;
	}
	public Boolean deleteBatch(MsgEntity mayi){
		msgDao.deleteBatch(mayi.getIds());
		return true;
	}
}
