//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.carloan.common.web;

import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageParameter {
    private static final Logger logger = LoggerFactory.getLogger(PageParameter.class);
    public static final int DEFAULT_PAGE_SIZE = 20;
    private int pageSize;
    private int currentPage;
    private int totalPage;
    private int totalCount;
    private Future futureResult;

    public Future getFutureResult() {
        return this.futureResult;
    }

    public void setFutureResult(Future futureResult) {
        this.futureResult = futureResult;
    }

    public PageParameter() {
        this.currentPage = 1;
        this.pageSize = 20;
    }

    public PageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        try {
            if(this.futureResult != null && "get".equals((String)this.futureResult.get())) {
                this.futureResult = null;
                return this.totalPage;
            }
        } catch (Exception var2) {
            logger.error("page.totalPage", var2);
        }

        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        try {
            if(this.futureResult != null && "get".equals((String)this.futureResult.get())) {
                this.futureResult = null;
                return this.totalCount;
            }
        } catch (Exception var2) {
            logger.error("page.totalCount", var2);
        }

        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageParameter [pageSize=");
        builder.append(this.pageSize);
        builder.append(", currentPage=");
        builder.append(this.currentPage);
        builder.append(", totalPage=");
        builder.append(this.totalPage);
        builder.append(", totalCount=");
        builder.append(this.totalCount);
        builder.append("]");
        return builder.toString();
    }
}
