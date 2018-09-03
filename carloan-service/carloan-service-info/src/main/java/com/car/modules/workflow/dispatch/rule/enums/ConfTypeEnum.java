package com.car.modules.workflow.dispatch.rule.enums;

import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by zhangyl on 2018/7/25
 * 规则类型
 */
public enum ConfTypeEnum {
    /**
     * 人对人
     */
    PTOP("1"),
    /**
     * 机构对角色
     */
    ORGTOROLE("2"),
    /**
     * 机构对人
     */
    ORGTOUSER("3"),
    /**
     * 机构对机构
     */
    ORGTOORG("4"),
    /**
     * 节点对角色
     */
    NODETOROLE("5"),
    ;
    private String confType;

    ConfTypeEnum(String confType) {
        this.confType = confType;
    }

    public static ConfTypeEnum acquire(final String serialize) {
        Optional<ConfTypeEnum> serializeEnum =
                Arrays.stream(ConfTypeEnum.values())
                        .filter(v -> Objects.equals(v.getConfType(), serialize))
                        .findFirst();

        return serializeEnum.get();
    }

    public String getConfType() {
        return confType;
    }

    public void setConfType(String confType) {
        this.confType = confType;
    }

    public static void main(String[] args) {
        System.out.println(acquire("0"));
    }
}
