package com.aiyyatti.algorithms.hackerrank.java;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class JavaSHA256 {
    @Test
    public void simpleTest() throws Exception {
        String str = "K1t4fo0V";
        TestCase.assertEquals("0a979e43f4874eb24b740c0157994e34636eed0425688161cc58e8b26b1dcf4e", doJavaSHA256(str));
    }

    public String doJavaSHA256(String str) {
        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            BigInteger bigInteger = new BigInteger(1, m.digest(str.getBytes()));
            String hashtext = bigInteger.toString(16);
            System.out.println(hashtext);
            while (hashtext.length() < 64) hashtext = "0" + hashtext;
            return hashtext;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
