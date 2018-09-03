package com.car.modules.loan.carloanmsg.dao;

import com.car.modules.loan.carloanmsg.dto.CarLoanMsgDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanMsgDao
 * @description: 定义  车辆信息 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  Administrator
 */
public interface CarLoanMsgDao {
    
    /**
     * @author Administrator
     * @description: 分页查询车辆信息
     * @date 2018-05-24 16:25:11
     * @param searchParams
     * @return
     */
    public List<CarLoanMsgDTO> searchCarLoanMsgByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author Administrator
     * @description:查询对象车辆信息
     * @date 2018-05-24 16:25:11
     * @param searchParams
     * @return
     */
    public List<CarLoanMsgDTO> searchCarLoanMsg(Map<String, Object> searchParams);

    /**
     * @author Administrator
     * @description:查询对象车辆信息
     * @date 2018-05-24 16:25:11
     * @param id
     * @return
     */
    public CarLoanMsgDTO findCarLoanMsgByPrimaryKey(String order_number);

    /**
     * @author Administrator
     * @description: 新增对象车辆信息
     * @date 2018-05-24 16:25:11
     * @param paramMap
     * @return
     */
    public int insertCarLoanMsg(Map<String, Object> paramMap);

    /**
     * @author Administrator
     * @description: 更新对象车辆信息
     * @date 2018-05-24 16:25:11
     * @param paramMap
     */
    public void updateCarLoanMsg(Map<String, Object> paramMap);

    /**
     * @author Administrator
     * @description: 按主键删除车辆信息
     * @date 2018-05-24 16:25:11
     * @param ids
     * @return
     */
    public void deleteCarLoanMsgByPrimaryKey(Map<String, Object> paramMap);
    /*---------------手写的----------------*/
    /**
     * @author Administrator
     * @description:查询对象车辆信息
     * @date 2018-05-24 16:25:11
     * @param order_number
     * @return
     */
    public CarLoanMsgDTO findCarLoanMsgByOrderNum(String order_number);

    /**
     * @author Administrator
     * @description: 更新对象车辆审核状态
     * @date 2018-05-24 16:25:11
     * @param paramMap
     */
    public void updateCarLoanMsgAuditState(Map<String, Object> paramMap);

    /**
     * 根据订单号查询任务信息,任务id和流程实例id
     * @param paramMap
     * @return
     */
    public HashMap findTaskInfoByOrderNum(Map<String, Object> paramMap);


    List<CarLoanMsgDTO> searchCarLoanMsgs(Map<String, Object> searchParams);

}
