package com.carloan.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具类
 */
public class EncryptUtil {
    /**
     * 加密密码
     * @param passWord
     * @return
     */
    public static String encryptPwd(String passWord){
        String encryptPwd= DigestUtils.md5Hex(passWord);//md5加密
        encryptPwd=DigestUtils.sha256Hex(encryptPwd+passWord);//sha256
        encryptPwd=DigestUtils.md5Hex(encryptPwd);//md5
        return encryptPwd;
    }
}
