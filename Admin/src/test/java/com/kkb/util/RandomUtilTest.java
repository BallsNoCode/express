package com.kkb.util;

import junit.framework.TestCase;
import org.junit.Test;

public class RandomUtilTest extends TestCase {


    public void testGetRandomNickname() {
    }

    @Test
    public void testTestRandom1() {
        RandomUtil randomUtil = new RandomUtil();
        String s = randomUtil.getCode();
        System.out.println(s);
    }
}