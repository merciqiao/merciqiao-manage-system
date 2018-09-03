package com.carloan.common.web.annotation;

import java.lang.annotation.*;

/**
 * @author 周志伟
 * @projectname 项目名称: ${project_name}
 * @classname: Page
 *
 * 自定义注解实现分页，只需在service 方法上添加 即可
 *
 * @description:
 * @date 2018/7/23：16:11
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  Page {
}
