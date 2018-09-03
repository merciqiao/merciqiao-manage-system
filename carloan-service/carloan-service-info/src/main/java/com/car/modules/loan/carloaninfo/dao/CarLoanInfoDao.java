package com.car.modules.loan.carloaninfo.dao;

import com.car.modules.loan.carloaninfo.dto.CarLoanInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanInfoDao
 * @description: 定义  信审车贷订单表 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanInfoDao {
    
    /**
     * @author root
     * @description: 分页查询信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param searchParams
     * @return
     */
    public List<CarLoanInfoDTO> searchCarLoanInfoByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param searchParams
     * @return
     */
    public List<CarLoanInfoDTO> searchCarLoanInfo(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param id
     * @return
     */
    public CarLoanInfoDTO findCarLoanInfoByPrimaryKey(String id);

    public CarLoanInfoDTO findCarLoanInfoOrdernumber(String Ordernumber);


    /**
     * @author root
     * @description: 新增对象信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param paramMap
     * @return
     */
    public int insertCarLoanInfo(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param paramMap
     */
    public void updateCarLoanInfo(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param ids
     * @return
     */ 
    public void deleteCarLoanInfoByPrimaryKey(Map<String, Object> paramMap);


    public int countSqlinfo(Map<String, Object> paramMap);

    public Map<String, String>  getValueMap(Map<String, Object> paramMap);

    /**
     * @author Administrator
     * @description: 更新车贷信审表审核状态
     * @date 2018-05-24 16:25:11
     * @param paramMap
     */
    public int updateCarLoanInfoAuditState(Map<String, Object> paramMap);
    /**
     * @author Administrator
     * @description: 更新车贷信审表审核信息
     * @date 2018-05-24 16:25:11
     * @param paramMap
     */
    public int updateCarLoanInfoAuditInfo(Map<String, Object> paramMap);
    /**
     * @author root
     * @description:查询对象信审车贷订单表
     * @date 2018-05-24 05:09:46
     * @param orderNum
     * @return
     */
    public CarLoanInfoDTO findCarLoanInfoByOrderNum(String orderNum);
}
