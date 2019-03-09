package com.carloan.service.admin.ycyscore.service.impl;

import com.carloan.common.web.annotation.Page;
import com.carloan.service.admin.ycyscore.dao.YcyscoreDao;
import com.carloan.service.admin.ycyscore.entity.YcyscoreEntity;
import com.carloan.service.admin.ycyscore.entity.YcyscoreListEntity;
import com.carloan.service.admin.ycyscore.service.YcyscoreService;
import com.carloan.service.admin.ycyscore.vo.YcyscoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ycyscoreService")
public class YcyscoreServiceImpl implements YcyscoreService {
	@Autowired
	private YcyscoreDao ycyscoreDao;
	
	@Override
	public YcyscoreVO queryObject(String ip){
	 	YcyscoreVO vo=ycyscoreDao.queryObject(ip);
		return vo;
	}

	@Override
	public boolean save(YcyscoreEntity ycyscore){
		 ycyscoreDao.save(ycyscore);
		 return true;
	}
	
	@Override
	public boolean update(YcyscoreEntity ycyscore){
		ycyscoreDao.update(ycyscore);
		return true;

	}
	@Page
	public Object queryList(YcyscoreEntity ycyscore){

		return ycyscoreDao.queryList(ycyscore);
	}
	@Override
	public int queryRank(YcyscoreEntity ycyscore){
		return ycyscoreDao.queryRank(ycyscore);
	}
	@Override
	public Integer queryTotal(){
		return ycyscoreDao.queryTotal();
	}

}
