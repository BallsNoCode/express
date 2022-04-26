package com.kkb.util;

import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * @author APPDE
 */
public class RandomUtil {

    private Random random = new Random();

    public String getRandomNickname(int length) {
        String val = "";
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 随机生成取件码
     * @return 取件码
     */
    public String getCode() {
        String s = "ABCDEFG";
        char[] c = s.toCharArray();
        Random random = new Random();
        String code = "";
        String letter = String.valueOf(c[random.nextInt(c.length)]);
        String number = getRandomNickname(1);
        code = letter + number;
        for (int i = 0; i < 2; i++) {
            code += "-";
            code += getRandomNickname(1);
        }
        return code;
    }

}
