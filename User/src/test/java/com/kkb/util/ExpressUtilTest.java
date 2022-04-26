package com.kkb.util;

import junit.framework.TestCase;
import lombok.val;

public class ExpressUtilTest extends TestCase {

    public void testQueryNum() {
        ExpressUtil expressUtil = new ExpressUtil();
        val s = expressUtil.queryNum("773155659870426");
        System.out.println(s);
    }
}