package com.car.modules.workflow.jbpm4biztab.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.car.modules.workflow.jbpm4biztab.dto.Jbpm4BizTabDTO;
import org.springframework.stereotype.Component;

/**
 * @classname: Jbpm4BizTabDao
 * @description: 定义  jbpm4_biz_tab 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
public interface Jbpm4BizTabDao {
    
    /**
     * @author root
     * @description: 分页查询jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param searchParams
     * @return
     */
    public List<Jbpm4BizTabDTO> searchJbpm4BizTabByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param searchParams
     * @return
     */
    public List<Jbpm4BizTabDTO> searchJbpm4BizTab(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param id
     * @return
     */
    public Jbpm4BizTabDTO findJbpm4BizTabByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param paramMap
     * @return
     */
    public int insertJbpm4BizTab(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param paramMap
     */
    public void updateJbpm4BizTab(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除jbpm4_biz_tab
     * @date 2018-06-27 05:16:35
     * @param ids
     * @return
     */ 
    public void deleteJbpm4BizTabByPrimaryKey(Map<String, Object> paramMap);
    /**
     * 根据订单号查询任务信息,流程实例id
     * @param paramMap
     * @return
     */
    public Jbpm4BizTabDTO findTaskInfoByOrderNum(Map<String, Object> paramMap);

    /**
     * 根据流程实例id更新任务结束时间和结束标示
     * @param paramMap
     * @return
     */
    public int updateJbpm4BizTabOver(Map<String, Object> paramMap);

    /**
     * 查询是否存在
     * @param paramMap
     * @return
     */
    public int findJbpm4BizTabExist(Map<String, Object> paramMap);
    
}
