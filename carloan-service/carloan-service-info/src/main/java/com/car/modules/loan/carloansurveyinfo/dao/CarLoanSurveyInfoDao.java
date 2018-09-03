package com.car.modules.loan.carloansurveyinfo.dao;

import com.car.modules.loan.carloansurveyinfo.dto.CarLoanSurveyInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanSurveyInfoDao
 * @description: 定义  car_loan_survey_info 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanSurveyInfoDao {
    
    /**
     * @author root
     * @description: 分页查询car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param searchParams
     * @return
     */
    public List<CarLoanSurveyInfoDTO> searchCarLoanSurveyInfoByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param searchParams
     * @return
     */
    public List<CarLoanSurveyInfoDTO> searchCarLoanSurveyInfo(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param id
     * @return
     */
    public CarLoanSurveyInfoDTO findCarLoanSurveyInfoByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param paramMap
     * @return
     */
    public int insertCarLoanSurveyInfo(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param paramMap
     */
    public void updateCarLoanSurveyInfo(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param paramMap
     * @return
     */ 
    public void deleteCarLoanSurveyInfoByPrimaryKey(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:查询对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param survey_contacts_id
     * @return
     */
    public CarLoanSurveyInfoDTO queryCarLoanSurveyInfoBySurveyContactsId(String survey_contacts_id);
    /**
     * @author root
     * @description:查询对象car_loan_survey_info
     * @date 2018-06-07 23:26:13
     * @param order_number,contactsInfo_id
     * @return
     */
    public CarLoanSurveyInfoDTO queryCarLoanSurveyInfoByOrderNumber(Map<String, Object> paramMap);
}
