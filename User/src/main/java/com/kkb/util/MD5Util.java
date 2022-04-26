package com.kkb.util;

import java.security.MessageDigest;

/**
 * @author APPDE
 */
public class MD5Util {

    /**
     * 密码密文
     */
    private static final String PASSWORD_KEY = "@#$%^&*()OPG#$%^&*(HG";
    private static final String PAY_KEY = "9964DYByKL967c3308imytCB";

    /**
     *
     * 数据加密
     * @param dataStr 被加密字符串
     * @param type 加密类型
     * @return 加密后字符串
     */
    public String encrypt(String dataStr,String type) {
        try {
            if ("password".equals(type)){
                dataStr += PASSWORD_KEY;
            }
            if ("pay".equals(type)){
                dataStr += PAY_KEY;
            }
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes("UTF8"));
            byte s[] = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00)
                        .substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
