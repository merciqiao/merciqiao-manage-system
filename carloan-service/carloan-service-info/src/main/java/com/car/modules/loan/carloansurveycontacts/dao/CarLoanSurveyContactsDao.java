package com.car.modules.loan.carloansurveycontacts.dao;

import com.car.modules.loan.carloansurveycontacts.dto.CarLoanSurveyContactsDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanSurveyContactsDao
 * @description: 定义  car_loan_survey_contacts 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanSurveyContactsDao {
    
    /**
     * @author root
     * @description: 分页查询car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param searchParams
     * @return
     */
    public List<CarLoanSurveyContactsDTO> searchCarLoanSurveyContactsByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param searchParams
     * @return
     */
    public List<CarLoanSurveyContactsDTO> searchCarLoanSurveyContacts(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param id
     * @return
     */
    public CarLoanSurveyContactsDTO findCarLoanSurveyContactsByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param paramMap
     * @return
     */
    public int insertCarLoanSurveyContacts(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param paramMap
     */
    public void updateCarLoanSurveyContacts(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param paramMap
     * @return
     */ 
    public void deleteCarLoanSurveyContactsByPrimaryKey(Map<String, Object> paramMap);

    /**
     * @author root
     * @description: 根据订单编号查询车贷订单原始联系人表和电核网核新增联系人表
     * @date 2018-06-10 21:57:13
     * @param paramMap
     * @return
     */
    public List<CarLoanSurveyContactsDTO> querySurveyContactsInfoByOrderNum(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:查询对象car_loan_survey_contacts
     * @date 2018-06-10 21:57:13
     * @param id
     * @return
     */
    public CarLoanSurveyContactsDTO querySurveyContactsInfoByOrderNum(String id);

    /**
     * @title: insertCarLoanSurveyContactsList
     * @author root
     * @description: 循环添加客户原始联系人
     * @date 2018-06-10 21:57:13
     * @param paramMap
     * @return
     * @throws
     */
    public void insertCarLoanSurveyContactsList(Map<String, Object> paramMap);
}
