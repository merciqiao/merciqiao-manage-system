package com.car.modules.loan.carloanrichtext.dao;

import com.car.modules.loan.carloanrichtext.dto.CarLoanRichTextDTO;

import java.util.List;
import java.util.Map;

/**
 * @classname: CarLoanRichTextDao
 * @description: 定义  car_loan_rich_text 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface CarLoanRichTextDao {
    
    /**
     * @author root
     * @description: 分页查询car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param searchParams
     * @return
     */
    public List<CarLoanRichTextDTO> searchCarLoanRichTextByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param searchParams
     * @return
     */
    public List<CarLoanRichTextDTO> searchCarLoanRichText(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param id
     * @return
     */
    public CarLoanRichTextDTO findCarLoanRichTextByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param paramMap
     * @return
     */
    public int insertCarLoanRichText(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param paramMap
     */
    public void updateCarLoanRichText(Map<String, Object> paramMap);

    /**
     * @author root
     * @description:查询对象car_loan_rich_text
     * @date 2018-06-08 21:13:03
     * @param paramMap
     * @return
     */
    public CarLoanRichTextDTO findCarLoanRichTextByNum(Map<String, Object> paramMap);
    
    
}
