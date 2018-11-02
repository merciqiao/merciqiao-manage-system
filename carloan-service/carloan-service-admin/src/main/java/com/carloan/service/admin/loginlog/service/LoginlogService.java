package com.carloan.service.admin.loginlog.service;

import com.carloan.service.admin.loginlog.dao.LoginlogDao;
import com.carloan.service.admin.loginlog.dto.LoginlogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loginlogService")
public class LoginlogService {
	@Autowired
	private LoginlogDao loginlogDao;

	public LoginlogEntity queryObject(Integer id){
		LoginlogEntity vo=loginlogDao.queryObject(id);
		return vo;
	}
	public void save(LoginlogEntity loginlog){
		loginlogDao.save(loginlog);

	}

	
}
