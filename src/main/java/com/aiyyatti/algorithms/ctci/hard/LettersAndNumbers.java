package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class LettersAndNumbers {
    private static final char a = 'A';
    private static final char o = 0;

    @Test
    public void testSimple() {
        char input[] = {a, o, o, a, a, a, a, a, a, a, o, o, o, a, a, o, a, o, a, o, a, a, o, o, o, a, a};
        assertEquals(9, doLetterAndNumbersBruteForce(input));
        assertEquals(9, doLetterAndNumbers(input));
    }

    public int doLetterAndNumbers(char[] c) {
        int max = 0, alpha = 0, num = 0, N = c.length;
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (c[i] == a) alpha++;
            else num++;

            int diff = alpha - num;
            if (!lookup.containsKey(diff)) lookup.put(diff, i);
            else max = Math.max(max, i - lookup.get(diff));
        }
        return max/2;
    }

    public int doLetterAndNumbersBruteForce(char[] c) {
        int N = c.length, max = 0;
        for (int i = 0; i < N; i++) {
            int alpha = 0, num = 0;
            for (int j = i; j < N; j++) {
                if (c[j] == a) alpha++;
                else num++;
                if (num == alpha) {
                    max = Math.max(max, alpha);
                    System.out.printf("%s --> %s = %s\n", i, j, alpha);
                }
            }
        }
        return max;
    }
}
