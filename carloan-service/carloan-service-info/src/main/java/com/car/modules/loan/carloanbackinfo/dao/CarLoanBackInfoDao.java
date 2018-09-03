package com.car.modules.loan.carloanbackinfo.dao;

import com.car.modules.loan.carloanbackinfo.dto.CarLoanBackInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanBackInfoDao
 * @description: 定义  car_loan_back_info 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanBackInfoDao {
    
    /**
     * @author root
     * @description: 分页查询car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param searchParams
     * @return
     */
    public List<CarLoanBackInfoDTO> searchCarLoanBackInfoByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param searchParams
     * @return
     */
    public List<CarLoanBackInfoDTO> searchCarLoanBackInfo(Map<String, Object> searchParams);


    /**
     * @author root
     * @description: 新增对象car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param paramMap
     * @return
     */
    public int insertCarLoanBackInfo(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param paramMap
     */
    public int updateCarLoanBackInfo(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param ids
     * @return
     */ 
    public void deleteCarLoanBackInfoByPrimaryKey(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:根据订单id查询对象car_loan_back_info
     * @date 2018-06-04 04:21:08
     * @param orderId
     * @return
     */
    public CarLoanBackInfoDTO findCarLoanBackInfoByOrderId(@Param("orderId")String orderId,@Param("ordertypecode") String ordertypecode);
    
    
}
