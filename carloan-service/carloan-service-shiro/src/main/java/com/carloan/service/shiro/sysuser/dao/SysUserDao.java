package com.carloan.service.shiro.sysuser.dao;

import java.util.List;
import java.util.Map;

import com.carloan.service.shiro.sysuser.dto.SysUserDTO;
import org.springframework.stereotype.Repository;

/**
 * @classname: SysUserDao
 * @description: 定义  sys_user 持久层 接口
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * @author:  root
 */
@Repository
public interface SysUserDao {
    
    /**
     * @author root
     * @description: 分页查询sys_user
     * @date 2018-06-20 23:14:46
     * @param searchParams
     * @return
     */
    public List<SysUserDTO> searchSysUserByPaging(Map<String, Object> searchParams) ;
    
    /**
     * @author root
     * @description:查询对象sys_user
     * @date 2018-06-20 23:14:46
     * @param searchParams
     * @return
     */
    public List<SysUserDTO> searchSysUser(Map<String, Object> searchParams);

    /**
     * @author root
     * @description:查询对象sys_user
     * @date 2018-06-20 23:14:46
     * @param id
     * @return
     */
    public SysUserDTO findSysUserByPrimaryKey(String id);
    
    /**
     * @author root
     * @description: 新增对象sys_user
     * @date 2018-06-20 23:14:46
     * @param paramMap
     * @return
     */
    public int insertSysUser(Map<String, Object> paramMap);
    
    /**
     * @author root
     * @description: 更新对象sys_user
     * @date 2018-06-20 23:14:46
     * @param paramMap
     */
    public void updateSysUser(Map<String, Object> paramMap);
     
    /**
     * @author root
     * @description: 按主键删除sys_user
     * @date 2018-06-20 23:14:46
     * @param ids
     * @return
     */ 
    public void deleteSysUserByPrimaryKey(Map<String, Object> paramMap);

    /**
     * 根据username查userinfo
     * @param paramMap
     * @return
     */
    public SysUserDTO getUserInfoByLoginName(Map<String, Object> paramMap);
}
