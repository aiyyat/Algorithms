package com.aiyyatti.algorithms.ctci.arraysandstrings;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IsUnique {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simple1Test() {
        String str = "derwant";
        assertTrue(checkIsUniqueWithInt(str));
        str = "connoisseur";
        assertFalse(checkIsUniqueWithInt(str));
        str = "abcd";
        assertTrue(checkIsUniqueWithInt(str));
        str = "abcaa";
        assertFalse(checkIsUniqueWithInt(str));
        str = "a";
        assertTrue(checkIsUniqueWithInt(str));
        str = "aa";
        assertFalse(checkIsUniqueWithInt(str));
    }

    @Test
    public void simple2Test() {
        String str = "derwant";
        assertTrue(checkIsUniqueBySorting(str));
        str = "connoisseur";
        assertFalse(checkIsUniqueBySorting(str));
        str = "abcd";
        assertTrue(checkIsUniqueBySorting(str));
        str = "abcaa";
        assertFalse(checkIsUniqueBySorting(str));
        str = "a";
        assertTrue(checkIsUniqueBySorting(str));
        str = "aa";
        assertFalse(checkIsUniqueBySorting(str));
    }

    @Test
    public void simple3Test() {
        String str = "derwant";
        assertTrue(checkIsUniqueWithAdditionalDS(str));
        str = "connoisseur";
        assertFalse(checkIsUniqueWithAdditionalDS(str));
        str = "abcd";
        assertTrue(checkIsUniqueWithAdditionalDS(str));
        str = "abcaa";
        assertFalse(checkIsUniqueWithAdditionalDS(str));
        str = "a";
        assertTrue(checkIsUniqueWithAdditionalDS(str));
        str = "aa";
        assertFalse(checkIsUniqueWithAdditionalDS(str));
    }

    /**
     * TODO: this can be used with 256 characters ascii input also.
     *
     * @param str
     * @return
     */
    public boolean checkIsUniqueWithAdditionalDS(String str) {
        boolean[] found = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (!found[index]) found[index] = true;
            else return false;
        }
        return true;
    }

    public boolean checkIsUniqueWithInt(String str) {
        int ref = 0;
        int N = str.length();
        for (int i = 0; i < N; i++) {
            int c = str.charAt(i) - 'a';
            int mask = 1 << c;
            if ((ref & mask) > 0) return false;
            else ref |= mask;
        }
        return true;
    }

    public boolean checkIsUniqueBySorting(String str) {
        char[] a = str.toCharArray();
        Arrays.sort(a);
        char prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == prev) return false;
            else prev = a[i];
        }
        return true;
    }
}
