package com.carloan.service.shiro.sysresource.dao;

import com.carloan.service.shiro.sysresource.dto.SysResourceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @classname: SysResourceDao
 * @description: 定义  sys_resource 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
@Repository
public interface SysResourceDao {
    
    /**
     * @author root
     * @description: 分页查询sys_resource
     * @date 2018-06-22 09:09:44
     * @param searchParams
     * @return
     */
    public List<SysResourceDTO> searchSysResourceByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象sys_resource
     * @date 2018-06-22 09:09:44
     * @param searchParams
     * @return
     */
    public List<SysResourceDTO> searchSysResource(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象sys_resource
     * @date 2018-06-22 09:09:44
     * @param id
     * @return
     */
    public SysResourceDTO findSysResourceByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象sys_resource
     * @date 2018-06-22 09:09:44
     * @param paramMap
     * @return
     */
    public int insertSysResource(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象sys_resource
     * @date 2018-06-22 09:09:44
     * @param paramMap
     */
    public void updateSysResource(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除sys_resource
     * @date 2018-06-22 09:09:44
     * @param ids
     * @return
     */ 
    public void deleteSysResourceByPrimaryKey(Map<String, Object> paramMap);

    /**
     * 查询shiro的权限, URL-角色
     * @param paramMap
     * @return
     */
    public List<SysResourceDTO> selectShiroRolePermission(Map<String, Object> paramMap);

    /**
     * 查询shiro的权限, URL-权限
     * @param paramMap
     * @return
     */
    public List<SysResourceDTO> selectShiroUrlPermission(Map<String, Object> paramMap);
    /**
     * 根据userid查询shiro的权限
     * @param paramMap
     * @return
     */
    public List<SysResourceDTO> selectShiroUrlPermissionByUserId(Map<String, Object> paramMap);
}
