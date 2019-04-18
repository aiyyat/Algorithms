package com.aiyyatti.algorithms.hackerrank.java;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class JavaMD5 {
    @Test
    public void simpleTest() throws Exception {
        String str = "HelloWorld";
        TestCase.assertEquals("68e109f0f40ca72a15e05cc22786f8e6", doJavaMD5(str));
    }

    public String doJavaMD5(String str) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            BigInteger bigInteger = new BigInteger(1, m.digest(str.getBytes()));
            String hashtext = bigInteger.toString(16);
            while (hashtext.length() < 32) hashtext = "0" + hashtext;
            return hashtext;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
