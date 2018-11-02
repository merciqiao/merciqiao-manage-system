package com.carloan.apimodel.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    public Status status=Status.SUCCESS;
    public String message="执行成功";

    /**
     * 是否成功
     * @param response
     * @return
     */
    public static Boolean isSucess(Response response){
        if(response.getStatus().getValue().equals(Status.SUCCESS.getValue())){
            return true;
        }
        else {
            return false;
        }
    }
}
