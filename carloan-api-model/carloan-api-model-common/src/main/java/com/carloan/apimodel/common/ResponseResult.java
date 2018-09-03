package com.carloan.apimodel.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ResponseResult<T> {
    /*消息状态*/
    public Status status;
    /*消息描述*/
    public String message;
    /*返回数据列表*/
    public List<T> dataList = new ArrayList();
    /*返回单条数据*/
    public T data;
    /*分页查询时数据总数*/
    public Integer count;

    /**
     * 是否成功
     *
     * @param response
     * @return
     */
    public static Boolean isSucess(ResponseResult response) {
        if (response.getStatus().getValue().equals(Status.SUCCESS.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isSucess() {
        if (status.getValue().equals(Status.SUCCESS.getValue())) {
            return true;
        } else {
            return false;
        }
    }

    public ResponseResult() {
        this.status = Status.SUCCESS;
        this.message = "成功";
    }
}
