package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

public class StringCompression {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        TestCase.assertEquals("", "aaabbcccccccdddefffghhh");
    }

    @Test
    public void simple2Test() {
        TestCase.assertEquals("a2b2c1", doCompression("aabbc"));
    }

    public String doCompression(String str) {
        char[] a = str.toCharArray();
        int N = str.length();
        String output = "";
        char prev = a[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (a[i] == prev) {
                count++;
            } else {
                output += "" + prev + count;
                count = 1;
                prev = a[i];
            }
        }
        output += "" + prev + count;
        return output;
    }
}
