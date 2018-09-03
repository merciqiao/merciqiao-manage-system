package com.car.modules.loan.biz.asynjob.service;

/**
 * Created by zhangyl on 2018/8/8
 */
public interface IBizAsynJobService {
    /**
     * 定义 接口方法
     * @param bizKeyId 业务主键ID
     * @return true: 表示需要不再被调用，false：表示需要继续被调用
     * @throws Exception
     */
    boolean executeAsynJob(String bizKeyId) throws Exception;
}
