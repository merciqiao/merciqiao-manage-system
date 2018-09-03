package com.car.modules.reqvo;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: Variable
 * @description:
 * @date 2018/5/28：14:53
 */
public class Variable {

    public static final String CAR_LOAN_INFO="select count(1) from car_loan_info where ORDER_NUMBER={0}";


    public static final String CAR_LOAN_MSG="select count(1) from CAR_LOAN_MSG where ORDER_NUMBER={0}";

    public static final String V1="订单编号已经存在车辆信息，不能重复进件，进件编号为---[{0}]";

    public static final String V2="订单编号已经存在客户信息，不能重复进件，进件编号为---[{0}]";

    public static final String V3= " SELECT PRICING_PRODUCT_TYPE,PRICING_CONCLUSION,PRICING_REMARKS,PRICING_MONEY from  CAR_LOAN_PRICE   WHERE  ORDER_NUMBER={0}  and STA_TUS={1} ORDER BY id DESC  LIMIT 1;";

    public static final String V4="SELECT COUNT(1) from  car_loan_file  WHERE ORDER_NUMBER={0}   and  HISTORY_URL={1}";

    public static final String V5="SELECT EXAMINE_REMARKS,APPROVAL_PERIOD,CURRENT_EXAMINATION_POST,CONTRACT_AMOUNT,PRODUCT_SERIES,getDetailName(REPAYMENT_METHOD,{2} )REPAYMENT_METHOD from  car_loan_opinion  WHERE  ORDER_NUMBER={0}   and  STA_TUS={1}    ORDER BY id DESC  LIMIT 1";

    public static final String V7=" SELECT  hh.ONE_LEVEL_CODE, hh.TWO_LEVEL_CODE,hh.TWO_LEVEL_NAME FROM  etl_order_user_img_type hh   WHERE  hh.IMGCODE ={0}";

    public static final String V8=" SELECT count(T1.ID) from lb_t_cust_attach T1 where  T1.FK_INTO_ID={1} and T1.HISTORY_MD5=#{0}";

    public static final String V9=" select mm.PRODUCT_CODE from lb_t_product_conf mm WHERE mm.PRODUCT_NAME={0}  and   mm.VALIDATE_STATE='1'";

    public static final String V10="订单编号不存在，不能进件，进件编号为---[{0}]";






    public static String Assemble(String val){
        return "'"+val+"'";
    }
    public static String getStatus(String auditState ,String orderNum) {
        String status = "";
        switch (auditState) {
            case "2100":
                status = "301";
                break;
            case "2200":
                status = "304";
                break;
            case "2700":
                status = "305";
                break;
            case "2400":
                status = "401";
                break;
            case "3100":
                status = "403";
                break;
            case "2300":
                status = "404";
                break;
            case "2600":
                status = "408";
                break;
            case "3500":
                status = "406";
                break;
            case "3600":
                status = "407";
                break;
        }
        return orderNum+":"+status;
    }

}
