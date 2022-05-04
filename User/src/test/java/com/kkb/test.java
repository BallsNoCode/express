package com.kkb;

import com.kkb.util.CdkUtil;
import com.kkb.util.RandomUtil;
import com.kkb.util.SMSUtil;
import com.kkb.util.TokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class test {
    @Test
    public void test() {
        RandomUtil randomUtil = new RandomUtil();
        String code = randomUtil.getRandomNickname(4);
        boolean send = SMSUtil.send("13360721887", code);
        System.out.println(send);
    }

    private static final int mask = 23;//大数异或的标
    private static Map<Integer, Integer> base = new HashMap<Integer, Integer>();//参数

    private static Random random = new Random();//随机数
    private static final int MAX_NUM = 10;//生成个数

    private static String prefix = "00";//前缀 可以扩展
    private static Set<String> cdks = new HashSet<>();//用于存储cdks

    @Test
    public void TestCdk() {
        //测试
        CdkUtil cdkUtil = new CdkUtil();
        for (int i = 0; i < 10; i++) {
            String randomString = cdkUtil.getRandomString(18);
            System.out.println(randomString);
        }
    }

    public static void main(String[] args) {
        TokenUtil tokenUtil = new TokenUtil();
        String token = tokenUtil.getToken();
        System.out.println(token);
    }

    @Around("get()")
    public void Test(ProceedingJoinPoint joinPoint){
        System.out.println("Around--start");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("Around--end");
    }


    public void get() {
        System.out.println("GET_Run");
    }
}
