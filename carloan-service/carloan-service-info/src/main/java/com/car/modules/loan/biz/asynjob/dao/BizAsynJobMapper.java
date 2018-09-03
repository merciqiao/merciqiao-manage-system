package com.car.modules.loan.biz.asynjob.dao;

import com.car.modules.loan.biz.asynjob.dto.BizAsynJobDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangYl on 2018/08/08
 */
public interface BizAsynJobMapper {

    int insertSelective(BizAsynJobDO bizAsynJobDO);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizAsynJobDO bizAsynJobDO);

    BizAsynJobDO selectByPrimaryKey(Long id);

    /**
     * 根据jobState批量查询异步任务
     * @param jobState
     * @return
     */
    List<BizAsynJobDO> listByJobState(@Param("jobState") Integer jobState);
}