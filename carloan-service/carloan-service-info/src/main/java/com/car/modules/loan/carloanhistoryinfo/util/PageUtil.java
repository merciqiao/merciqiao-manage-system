package com.car.modules.loan.carloanhistoryinfo.util;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class PageUtil<T> {
    /**
     * 每页显示条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 原集合
     */
    private List<T> data;

    public PageUtil(List<T> data, int pageSize) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("data must be not empty!");
        }

        this.data = data;
        this.pageSize = pageSize;
        this.pageCount = data.size()/pageSize;
        if(data.size()%pageSize!=0){
            this.pageCount++;
        }
    }

    /**
     * 得到分页后的数据
     *
     * @param pageNum 页码
     * @return 分页后结果
     */
    public List<T> getPagedList(int pageNum) {
        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return Collections.emptyList();
        }

        int toIndex = pageNum * pageSize;
        if (toIndex >= data.size()) {
            toIndex = data.size();
        }
        return data.subList(fromIndex, toIndex);
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public int getPageCount() {
        return pageCount;
    }

}
