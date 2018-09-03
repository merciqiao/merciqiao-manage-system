package com.car.modules.loan.carloanlog.dao;

import com.car.modules.loan.carloanlog.dto.CarLoanLogDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanLogDao
 * @description: 定义  CAR_LOAN_LOG 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  Administrator
 */
public interface CarLoanLogDao {
    
    /**
     * @author Administrator
     * @description: 分页查询CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param searchParams
     * @return
     */
    public List<CarLoanLogDTO> searchCarLoanLogByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author Administrator
     * @description:查询对象CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param searchParams
     * @return
     */
    public List<CarLoanLogDTO> searchCarLoanLog(Map<String, Object> searchParams);

    /**
     * @author Administrator
     * @description:查询对象CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param id
     * @return
     */
    public CarLoanLogDTO findCarLoanLogByPrimaryKey(String id);
    
    /**
     * @author Administrator
     * @description: 新增对象CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param paramMap
     * @return
     */
    public int insertCarLoanLog(Map<String, Object> paramMap);
    
    /**
     * @author Administrator
     * @description: 更新对象CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param paramMap
     */
    public void updateCarLoanLog(Map<String, Object> paramMap);
     
    /**
     * @author Administrator
     * @description: 按主键删除CAR_LOAN_LOG
     * @date 2018-05-24 16:24:05
     * @param ids
     * @return
     */ 
    public void deleteCarLoanLogByPrimaryKey(Map<String, Object> paramMap);
    
    
}
