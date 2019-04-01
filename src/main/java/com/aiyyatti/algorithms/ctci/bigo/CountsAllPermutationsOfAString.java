package com.aiyyatti.algorithms.ctci.bigo;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class CountsAllPermutationsOfAString {
    @Test
    public void simpleTest() {
        TestCase.assertEquals(6, doCountsAllPermutationsOfAString("abc", 0));
    }

    @Test
    public void simple2Test() {
        TestCase.assertEquals(24, doCountsAllPermutationsOfAString("abcd", 0));
    }

    public int doCountsAllPermutationsOfAString(String str, int index) {
        if (index == str.length()) {
            System.out.println(str);
            return 1;
        }
        int N = str.length();
        int count = 0;
        for (int i = index; i < N; i++) {
            count += doCountsAllPermutationsOfAString(str.substring(0, i) + str.substring(i + 1) + str.charAt(i), index + 1);
        }
        return count;
    }
}
