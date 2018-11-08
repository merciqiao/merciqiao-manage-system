package com.carloan.service.admin.mayirecord.service;

import com.carloan.service.admin.mayirecord.entity.MayirecordEntity;
import com.carloan.service.admin.mayirecord.vo.MayirecordVO;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:37:38
 */
public interface MayirecordService {

	MayirecordVO queryObject(Integer id);

	Boolean save(MayirecordEntity mayirecord);

	Boolean update(MayirecordEntity mayirecord);
	

}
