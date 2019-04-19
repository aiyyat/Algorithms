package com.aiyyatti.algorithms.ctci.arraysandstrings;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class URLify {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        String mr_john_smith = "Mr John Smith";
        char[] input = toArray(mr_john_smith);
        doURLify(input, mr_john_smith.length());
        char[] output = "Mr%20John%20Smith".toCharArray();
        assertArrayEquals(input, output);
    }

    public char[] toArray(String str) {
        int spaces = 0;
        for (int i = 0; i < str.length(); i++) if (str.charAt(i) == ' ') spaces++;
        for (int i = 0; i < spaces; i++) str += "  ";
        return str.toCharArray();
    }

    public void doURLify(char[] a, int N) {
        int spaceCount = 0;
        for (int i = 0; i < N; i++) if (a[i] == ' ') spaceCount++;
        int targetN = N - 1 + spaceCount * 2;
        for (int i = N - 1; i >= 0; i--) {
            if (a[i] == ' ') {
                a[targetN--] = '0';
                a[targetN--] = '2';
                a[targetN--] = '%';
            } else a[targetN--] = a[i];
        }
    }
}
