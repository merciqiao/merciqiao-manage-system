package com.carloan.apimodel.workflow.common;

/**
 * Created by MMM on 2018/06/01.
 * 车贷流程流转常量
 */
public class CarTransitionConst {
    /* 定价-流转名称---start */
    public static final String CONST_DINGJIA_TURNDIR_START="开始";
    public static final String CONST_DINGJIA_TURNDIR_AGREE="同意";
    public static final String CONST_DINGJIA_TURNDIR_REFUSE="拒绝";
    public static final String CONST_DINGJIA_TURNDIR_ROLLBACK="回退";
    public static final String CONST_DINGJIA_TURNDIR_ATTACH="补件";

    /* 定价-流转名称---end */

    /* 信审-流转名称---start */
    public static final String CONST_XINSHEN_TURNDIR_START="开始";
    public static final String CONST_XINSHEN_TURNDIR_AGREE_SHENHE="审核同意";
    public static final String CONST_XINSHEN_TURNDIR_AGREE_FUHE="复核同意";
    public static final String CONST_XINSHEN_TURNDIR_REFUSE_SHENHE="审核拒绝";
    public static final String CONST_XINSHEN_TURNDIR_REFUSE_FUHE="复核拒绝";
    public static final String CONST_XINSHEN_TURNDIR_LILEANTIFRAUD="疑似欺诈";
    public static final String CONST_XINSHEN_TURNDIR_ROLLBACK_BUJIAN="回退补件";
    public static final String CONST_XINSHEN_TURNDIR_ROLLBACK_SHENHE="回退审核";
    public static final String CONST_XINSHEN_TURNDIR_ROLLBACK_FUHE="回退复核";

    public static final String CONST_XINSHEN_TURNDIR_ATTACH="补件";
    public static final String CONST_XINSHEN_TURNDIR_NOTANTIFRAUD="非欺诈";
    public static final String CONST_XINSHEN_TURNDIR_ANTIFRAUD="欺诈";
    /* 信审-流转名称---end */

    /* 复议-流转名称---start */
    public static final String CONST_FUYI_TURNDIR_START="开始";
    public static final String CONST_FUYI_TURNDIR_AGREE="同意";
    public static final String CONST_FUYI_TURNDIR_REFUSE="拒绝";
    /* 复议-流转名称---end */
}
