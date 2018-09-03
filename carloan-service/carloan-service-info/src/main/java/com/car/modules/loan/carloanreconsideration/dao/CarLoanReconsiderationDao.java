package com.car.modules.loan.carloanreconsideration.dao;

import com.car.modules.loan.carloanreconsideration.dto.CarLoanReconsiderationDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanReconsiderationDao
 * @description: 定义  车贷复议表 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanReconsiderationDao {
    
    /**
     * @author root
     * @description: 分页查询车贷复议表
     * @date 2018-05-28 01:51:28
     * @param searchParams
     * @return
     */
    public List<CarLoanReconsiderationDTO> searchCarLoanReconsiderationByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象车贷复议表
     * @date 2018-05-28 01:51:28
     * @param searchParams
     * @return
     */
    public List<CarLoanReconsiderationDTO> getCarLoanReconsiderationList(String ordernum);

    /**
     * @author root
     * @description:查询对象车贷复议表
     * @date 2018-05-28 01:51:28
     * @param id
     * @return
     */
    public CarLoanReconsiderationDTO findCarLoanReconsiderationByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象车贷复议表
     * @date 2018-05-28 01:51:28
     * @param paramMap
     * @return
     */
    public int insertCarLoanReconsideration(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象车贷复议表
     * @date 2018-05-28 01:51:28
     * @param paramMap
     */
    public void updateCarLoanReconsideration(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除车贷复议表
     * @date 2018-05-28 01:51:28
     * @param ids
     * @return
     */ 
    public void deleteCarLoanReconsiderationByPrimaryKey(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:查询对象车贷复议表
     * @param orderNum
     * @return
     */
    public CarLoanReconsiderationDTO findCarLoanReconsiderationByOrderNum(String orderNum);

    /**
     * 更新订单状态
     * @param paramMap
     */
    public void  updateCarLoanReconsiderationAuditState(Map<String, Object> paramMap);
}
