package com.carloan.apimodel.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/3.
 */
@Getter
@Setter
public class PageInfoExt  implements Serializable {
    private int pageSize;
    private int currentPage;
}
