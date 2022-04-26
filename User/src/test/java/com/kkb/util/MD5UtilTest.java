package com.kkb.util;

import junit.framework.TestCase;
import org.junit.Test;

public class MD5UtilTest extends TestCase {

    @Test
    public void testEncrypt() {
        MD5Util md5Util = new MD5Util();
        System.out.println(md5Util.encrypt("178011", "pay"));
    }
}