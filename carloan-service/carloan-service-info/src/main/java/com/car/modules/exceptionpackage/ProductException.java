package com.car.modules.exceptionpackage;



/**
 * 
 * @projectname  项目名称: rm
 * @description  功能描述: JsonException
 * @author       作        者: 周志伟
 * @Createdate   建立日期: 2017年5月3日下午2:33:58
 */
@SuppressWarnings("serial")
public class ProductException extends Exception {

    public ProductException() {
        // TODO Auto-generated constructor stub
    }

    public ProductException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ProductException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }


}
