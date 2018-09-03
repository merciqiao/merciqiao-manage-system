package com.carloan.apimodel.shiro;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *@Description:sys_role
 *@author root
 *@version 1.0,
 *@date 2018-06-22 02:10:07
 */
@Getter
@Setter
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * ROLE_NAME
     */
    private String roleName;

    /**
     * ROLE_CODE
     */
    private String roleCode;

    /**
     * ROLE_TYPE
     */
    private String roleType;





}
