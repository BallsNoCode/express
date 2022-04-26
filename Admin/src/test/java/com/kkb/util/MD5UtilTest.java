package com.kkb.util;

import junit.framework.TestCase;

public class MD5UtilTest extends TestCase {

    public void testEncrypt() {
        MD5Util md5Util = new MD5Util();
        String encrypt = md5Util.encrypt("undefined","password");
        System.out.println(encrypt);
    }
}