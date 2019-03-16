package com.carloan.service.admin.ycyscore.service;

import com.carloan.service.admin.ycyscore.entity.YcyscoreEntity;
import com.carloan.service.admin.ycyscore.entity.YcyscoreListEntity;
import com.carloan.service.admin.ycyscore.vo.YcyscoreVO;

import java.util.List;

/**
 * 
 * 
 * @author qlx
 * @email qiaolixue@yingu.com
 * @date 2019-03-09 14:21:07
 */
public interface YcyscoreService {

	YcyscoreVO queryObject(String ip);

	public YcyscoreVO queryObjectToday(String ip);

	boolean save(YcyscoreEntity ycyscore);

	boolean update(YcyscoreEntity ycyscore);

	public Object queryList(YcyscoreEntity ycyscore);

	public Object querySpeedList(YcyscoreEntity ycyscore);

	public Object queryToday(YcyscoreEntity ycyscore);

	public int queryRank(YcyscoreEntity ycyscore);

	public YcyscoreVO querySpeedRank(YcyscoreEntity ycyscore);

	public YcyscoreVO queryRankToday(YcyscoreEntity ycyscore);

	public Integer queryTotal();
}
