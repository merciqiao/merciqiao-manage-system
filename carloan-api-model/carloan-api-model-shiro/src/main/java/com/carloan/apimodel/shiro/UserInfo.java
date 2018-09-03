package com.carloan.apimodel.shiro;


import lombok.*;
import org.dozer.Mapping;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class UserInfo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Mapping("id")
    private Long userId;
    private String userName;
    private String userNo;
    private String loginName;
    private Long orgId;
    private String orgName;
    private String salt;
    private String password;
    private String email;
    private String loginTime;
    private String orgParentId;
    private String orgParentName;
    private String positionName;
    /*sessionid*/
    private String token;
}
