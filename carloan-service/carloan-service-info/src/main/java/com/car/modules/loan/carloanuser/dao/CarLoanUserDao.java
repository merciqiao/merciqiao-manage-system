package com.car.modules.loan.carloanuser.dao;

import com.car.modules.loan.carloanuser.dto.CarLoanUserDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanUserDao
 * @description: 定义  车贷个人信息表 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanUserDao {
    
    /**
     * @author root
     * @description: 分页查询车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param searchParams
     * @return
     */
    public List<CarLoanUserDTO> searchCarLoanUserByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param searchParams
     * @return
     */
    public List<CarLoanUserDTO> searchCarLoanUser(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param id
     * @return
     */
    public CarLoanUserDTO findCarLoanUserByPrimaryKey(String id);
    public CarLoanUserDTO queryCarLoanUserByOrderNum(String orderNum);
    /**
     * @author root
     * @description: 新增对象车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param paramMap
     * @return
     */
    public int insertCarLoanUser(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param paramMap
     */
    public void updateCarLoanUser(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除车贷个人信息表
     * @date 2018-05-25 01:26:23
     * @param ids
     * @return
     */ 
    public void deleteCarLoanUserByPrimaryKey(Map<String, Object> paramMap);


    CarLoanUserDTO searchCarLoanUserByDetail(Map<String, Object> searchParams);
}
