package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

public class StringRotation {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void test1StringRotation() {
        TestCase.assertTrue(doStringRotation(rotateBy("abcdefg", 4), "defgabcd"));
    }

    @Test
    public void test2StringRotation() {
        TestCase.assertFalse(doStringRotation(rotateBy("abcdefgh", 4), "defgabcd"));
    }

    public boolean doStringRotation(String str1, String str2) {
        return isSubString(str1 + str1, str2);
    }

    public String rotateBy(String str, int i) {
        int N = str.length();
        return str.substring(N - 1 - 2) + str.substring(0, N - 1 - 2);
    }

    public boolean isSubString(String big, String small) {
        return big.indexOf(small) != -1;
    }

    public boolean isSubString(String big, String small, int indexbig, int indexsmall) {
        if (indexsmall == small.length()) return true;
        else if (indexbig + small.length() - indexsmall > big.length() - 1) return false;
        if (big.charAt(indexbig) == small.charAt(indexsmall)) {
            indexbig++;
            indexsmall++;
        } else {
            indexbig++;
            indexsmall = 0;
        }
        return isSubString(big, small, indexbig, indexsmall);
    }

    @Test
    public void testIsSubString3() {
        TestCase.assertFalse(isSubString("SunFlower", "z"));
    }

    @Test
    public void testIsSubString2() {
        TestCase.assertTrue(isSubString("SunFlower", "F"));
    }

    @Test
    public void testIsSubString1() {
        TestCase.assertTrue(isSubString("SunFlower", "Flow"));
    }

    @Test
    public void testIsSubString4() {
        TestCase.assertFalse(isSubString("SunFlower", "Flowz"));
    }
}
