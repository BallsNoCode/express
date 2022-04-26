package com.kkb.util;

import junit.framework.TestCase;

public class CdkUtilTest extends TestCase {

    public void testGetRandomString() {
        CdkUtil cdkUtil = new CdkUtil();
        for (int i = 0; i < 10; i++) {
            String randomString = cdkUtil.getRandomString(18);
            System.out.println(randomString);
        }
    }
}