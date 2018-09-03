package com.carloan.service.shiro.sysrole.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.shiro.sysrole.dto.SysRoleDTO;
import org.springframework.stereotype.Repository;

/**
 * @classname: SysRoleDao
 * @description: 定义  sys_role 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
@Repository
public interface SysRoleDao {
    
    /**
     * @author root
     * @description: 分页查询sys_role
     * @date 2018-06-22 02:10:07
     * @param searchParams
     * @return
     */
    public List<SysRoleDTO> searchSysRoleByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象sys_role
     * @date 2018-06-22 02:10:07
     * @param searchParams
     * @return
     */
    public List<SysRoleDTO> searchSysRole(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象sys_role
     * @date 2018-06-22 02:10:07
     * @param id
     * @return
     */
    public SysRoleDTO findSysRoleByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象sys_role
     * @date 2018-06-22 02:10:07
     * @param paramMap
     * @return
     */
    public int insertSysRole(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象sys_role
     * @date 2018-06-22 02:10:07
     * @param paramMap
     */
    public void updateSysRole(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除sys_role
     * @date 2018-06-22 02:10:07
     * @param ids
     * @return
     */ 
    public void deleteSysRoleByPrimaryKey(Map<String, Object> paramMap);

    /**
     * 根据userid查询所属角色集合
     * @param paramMap
     * @return
     */
    List<SysRoleDTO> selectSysRoleByUserId(Map<String, Object> paramMap);
}
