package com.carloan.apimodel.biz.enums;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by zhangyl on 2018/8/8
 */
public enum AsynJobEnum {
    /**
     * 任务完成
     */
    COMPLETE(0),
    /**
     * 异步调用接口
     */
    ASYN(1),
    /**
     * 启动流程
     */
    START_JBPM(2),
    ;
    private int status;

    AsynJobEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static AsynJobEnum acquire(final int serialize) {
        Optional<AsynJobEnum> serializeEnum =
                Arrays.stream(AsynJobEnum.values())
                        .filter(v -> Objects.equals(v.getStatus(), serialize))
                        .findFirst();

        return serializeEnum.get();
    }

    public static void main(String[] args) {
        System.out.println(acquire(1));
    }
}
