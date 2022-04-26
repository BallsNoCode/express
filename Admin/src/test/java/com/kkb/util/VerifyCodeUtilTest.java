package com.kkb.util;

import junit.framework.TestCase;

import java.awt.image.BufferedImage;

public class VerifyCodeUtilTest extends TestCase {

    public void testDrawRandomText() {
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        BufferedImage verifyImg=new BufferedImage(200,69, BufferedImage.TYPE_INT_RGB);
        String s = verifyCodeUtil.drawRandomText(200, 69, verifyImg);
        System.out.println(s);
    }
}