//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.carloan.common.web;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.validation.annotation.Validated;

@Validated
public class HeaderBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String globalID;

    private String categoryCode;

    private String requestTime = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date());

    private String interfaceName;
    private String BAK1;
    private String BAK2;

    public String getCategoryCode() {
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getGlobalID() {
        return this.globalID;
    }

    public void setGlobalID(String globalID) {
        this.globalID = globalID;
    }

    public String getBAK1() {
        return this.BAK1;
    }

    public void setBAK1(String bAK1) {
        this.BAK1 = bAK1;
    }

    public String getBAK2() {
        return this.BAK2;
    }

    public void setBAK2(String bAK2) {
        this.BAK2 = bAK2;
    }

    public HeaderBean() {
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("headerBean [globalID=");
        builder.append(this.getGlobalID());
        builder.append(", categoryCode=");
        builder.append(this.getCategoryCode());
        builder.append(",interfaceName=");
        builder.append(this.getInterfaceName());
        builder.append(", requestTime=");
        builder.append(this.getRequestTime());
        builder.append(", BAK1=");
        builder.append(this.getBAK1());
        builder.append(", BAK2=");
        builder.append(this.getBAK2());
        builder.append("]");
        return builder.toString();
    }
}
