package com.car.modules.loan.carloanfile.dao;

import com.car.modules.loan.carloanfile.dto.CarLoanFileDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanFileDao
 * @description: 定义  申请人联系人信息 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanFileDao {
    
    /**
     * @author root
     * @description: 分页查询申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param searchParams
     * @return
     */
    public List<CarLoanFileDTO> searchCarLoanFileByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param searchParams
     * @return
     */
    public List<CarLoanFileDTO> searchCarLoanFile(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param id
     * @return
     */
    public CarLoanFileDTO findCarLoanFileByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param paramMap
     * @return
     */
    public int insertCarLoanFile(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param paramMap
     */
    public void updateCarLoanFile(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除申请人联系人信息
     * @date 2018-05-24 07:50:11
     * @param ids
     * @return
     */ 
    public void deleteCarLoanFileByPrimaryKey(Map<String, Object> paramMap);


    public List<CarLoanFileDTO> findCarLoanFileOrderNum(String orderNum);



}
