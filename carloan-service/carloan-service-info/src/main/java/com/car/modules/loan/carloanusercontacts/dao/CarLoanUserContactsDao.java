package com.car.modules.loan.carloanusercontacts.dao;

import com.car.modules.loan.carloanusercontacts.dto.CarLoanUserContactsDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanUserContactsDao
 * @description: 定义  申请人联系人信息 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanUserContactsDao {
    
    /**
     * @author root
     * @description: 分页查询申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param searchParams
     * @return
     */
    public List<CarLoanUserContactsDTO> searchCarLoanUserContactsByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param searchParams
     * @return
     */
    public List<CarLoanUserContactsDTO> searchCarLoanUserContacts(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param id
     * @return
     */
    public CarLoanUserContactsDTO findCarLoanUserContactsByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param paramMap
     * @return
     */
    public int insertCarLoanUserContacts(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param paramMap
     */
    public void updateCarLoanUserContacts(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除申请人联系人信息
     * @date 2018-05-24 05:03:25
     * @param paramMap
     * @return
     */ 
    public void deleteCarLoanUserContactsByPrimaryKey(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:根据订单号查询订单原始联系人
     * @date 2018-05-24 05:09:46
     * @param param
     * @return
     */
    public List findCarLoanUserContactsByOrderNum(Map param);

}
