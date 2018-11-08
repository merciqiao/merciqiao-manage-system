package com.carloan.service.admin.mayirecord.service.impl;

import com.carloan.service.admin.mayirecord.dao.MayirecordDao;
import com.carloan.service.admin.mayirecord.entity.MayirecordEntity;
import com.carloan.service.admin.mayirecord.service.MayirecordService;
import com.carloan.service.admin.mayirecord.vo.MayirecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mayirecordService")
public class MayirecordServiceImpl implements MayirecordService {
	@Autowired
	private MayirecordDao mayirecordDao;
	
	@Override
	public MayirecordVO queryObject(Integer id){
	 	MayirecordVO vo=mayirecordDao.queryObject(id);
		return vo;
	}

	@Override
	public Boolean save(MayirecordEntity mayirecord){
		mayirecordDao.save(mayirecord);
		return true;
	}

	@Override
	public Boolean update(MayirecordEntity mayirecord){
		mayirecordDao.update(mayirecord);
		return true;
	}
	

}
