package com.kkb.util;

import java.util.Random;


/**
 * @author APPDE
 */
public class CdkUtil {

    /**
     * 随机生成CDK
     * @param length 生成字符长度
     * @return 生成CDK
     */
    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
