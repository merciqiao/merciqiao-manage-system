package com.carloan.service.admin.mayi.service.impl;

import com.carloan.service.admin.mayi.dao.MayiDao;
import com.carloan.service.admin.mayi.entity.MayiEntity;
import com.carloan.service.admin.mayi.entity.MayiListEntity;
import com.carloan.service.admin.mayi.service.MayiService;
import com.carloan.service.admin.mayi.vo.MayiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mayiService")
public class MayiServiceImpl implements MayiService {
	@Autowired
	private MayiDao mayiDao;
	
	@Override
	public MayiVO queryObject(String ip){
	 	MayiVO vo=mayiDao.queryObject(ip);
		return vo;
	}
	
	@Override
	public Boolean queryList(MayiListEntity mayi){
		
		return true;
	}
	
	@Override
	public Boolean save(MayiEntity mayi){
		mayiDao.save(mayi);
		return true;
	}
	
	@Override
	public Boolean update(MayiEntity mayi){
		mayiDao.update(mayi);
		return true;
	}

	
}
