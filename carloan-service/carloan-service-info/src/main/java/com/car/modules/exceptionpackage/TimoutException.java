package com.car.modules.exceptionpackage;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: TimoutException
 * @description:
 * @date 2017/9/22：9:23
 */
public class TimoutException   extends Exception{


    public TimoutException() {
        // TODO Auto-generated constructor stub
    }

    public TimoutException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public TimoutException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public TimoutException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
