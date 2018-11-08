package com.carloan.service.admin.mayi.service;

import com.carloan.service.admin.mayi.entity.MayiEntity;
import com.carloan.service.admin.mayi.entity.MayiListEntity;
import com.carloan.service.admin.mayi.vo.MayiVO;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2018-11-08 18:35:17
 */
public interface MayiService {

	MayiVO queryObject(String ip);

	Boolean queryList(MayiListEntity mayi);

	Boolean save(MayiEntity mayi);

	Boolean update(MayiEntity mayi);
	

}
