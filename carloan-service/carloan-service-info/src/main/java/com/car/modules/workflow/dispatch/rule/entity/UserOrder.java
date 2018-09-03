package com.car.modules.workflow.dispatch.rule.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zhangyl on 2018/7/26
 */
@Getter
@Setter
public class UserOrder implements Serializable {
    private static final long serialVersionUID = 3210100697247619969L;
    private Long userId;
    private int num;
}
