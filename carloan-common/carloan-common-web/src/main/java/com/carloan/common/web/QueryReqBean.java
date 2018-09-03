//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.carloan.common.web;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class QueryReqBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private PageParameter pageParameter = null;
    private Map<String, Object> searchParams = null;
    private String sortExp = null;
    private HeaderBean headerBean = null;

    public QueryReqBean() {
    }

    public PageParameter getPageParameter() {
        if(this.pageParameter == null) {
            this.pageParameter = new PageParameter();
        } else if(this.pageParameter.getFutureResult() != null) {
            this.pageParameter.getTotalCount();
            this.pageParameter.setFutureResult((Future)null);
        }

        return this.pageParameter;
    }

    public void setPageParameter(PageParameter pageParameter) {
        this.pageParameter = pageParameter;
    }

    public Map<String, Object> getSearchParams() {
        if(this.searchParams == null) {
            this.searchParams = new HashMap();
        }

        if(this.pageParameter != null) {
            this.searchParams.put("page", this.pageParameter);
        }

        if(this.sortExp != null) {
            this.searchParams.put("sortExp", this.sortExp);
        }

        return this.searchParams;
    }

    public void setSearchParams(Map<String, Object> searchParams) {
        this.searchParams = searchParams;
    }

    public String getSortExp() {
        return this.sortExp;
    }

    public void setSortExp(String sortExp) {
        this.sortExp = sortExp;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("QueryReqBean [pageParameter=");
        builder.append(this.pageParameter);
        builder.append(", searchParams=");
        builder.append(this.searchParams);
        builder.append(", sortExp=");
        builder.append(this.sortExp);
        builder.append("]");
        return builder.toString();
    }

    public HeaderBean getHeaderBean() {
        return this.headerBean;
    }

    public void setHeaderBean(HeaderBean headerBean) {
        this.headerBean = headerBean;
    }
}
