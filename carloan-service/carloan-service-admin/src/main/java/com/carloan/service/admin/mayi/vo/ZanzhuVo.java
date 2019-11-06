package com.carloan.service.admin.mayi.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ZanzhuVo {
    public int id;
    public String name;
    public BigDecimal money;
    public String remark;
    public String qq;
    public Date createtime;
}
