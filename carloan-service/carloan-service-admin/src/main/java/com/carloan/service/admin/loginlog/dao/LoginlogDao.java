package com.carloan.service.admin.loginlog.dao;


import com.carloan.service.admin.loginlog.dto.LoginlogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-01 22:54:18
 */
public interface LoginlogDao  {

	public LoginlogEntity queryObject(Integer id);

	public List<LoginlogEntity> queryList(LoginlogEntity loginlog);

	
	public void save(LoginlogEntity loginlog);
	
	public void update(LoginlogEntity loginlog);
	
	public void delete(Integer id);
	
	public void deleteBatch(Integer[] ids);

	public void rollBackTables();
	
}
