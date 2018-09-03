package com.car.modules.loan.carloancalphonelog.dao;

import com.car.modules.loan.carloancalphonelog.dto.CarLoanCalPhoneLogDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanCalPhoneLogDao
 * @description: 定义  car_loan_cal_phone_log 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanCalPhoneLogDao {
    
    /**
     * @author root
     * @description: 分页查询car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param searchParams
     * @return
     */
    public List<CarLoanCalPhoneLogDTO> searchCarLoanCalPhoneLogByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param searchParams
     * @return
     */
    public List<CarLoanCalPhoneLogDTO> searchCarLoanCalPhoneLog(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param id
     * @return
     */
    public CarLoanCalPhoneLogDTO findCarLoanCalPhoneLogByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param paramMap
     * @return
     */
    public int insertCarLoanCalPhoneLog(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param paramMap
     */
    public void updateCarLoanCalPhoneLog(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除car_loan_cal_phone_log
     * @date 2018-06-07 23:29:04
     * @param ids
     * @return
     */ 
    public void deleteCarLoanCalPhoneLogByPrimaryKey(Map<String, Object> paramMap);

    public CarLoanCalPhoneLogDTO queryInfo(Map param);

    public List<CarLoanCalPhoneLogDTO> queryCarLoanCalPhoneLogInfoByParam(Map<String, Object> paramMap);
}
