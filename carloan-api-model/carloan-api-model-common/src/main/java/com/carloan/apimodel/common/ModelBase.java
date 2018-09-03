package com.carloan.apimodel.common;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * DTO和VO的基类提供幂等的uuid
 */
@Getter
@Setter
public class ModelBase {
    public String uuid= UUID.randomUUID().toString();
}
