package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: dynamic 24.14; bruteforce: 2.24
 * Todo: Character.isDigit was not working, isLetter is. store letters and numbers in an array of chars or ints?
 * Redo: No
 * Notes: when initializing max remember which is the min guaranteed value it could have.
 */
public class LettersAndNumbers {
    private static final Logger logger = getLogger(LettersAndNumbers.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest1() {
        char a = 'a';
        char o = 1;
        char[] input = new char[]{a, o, a, a, a, o, o, a};
        assertThat(doLettersAndNumbers(input)).isEqualTo(6);
        assertThat(doLettersAndNumbersBruteForce(input)).isEqualTo(6);
    }

    @Test
    public void simpleTest2() {
        char a = 'a';
        char o = 1;
        char[] input = new char[]{a};
        assertThat(doLettersAndNumbers(input)).isEqualTo(0);
        assertThat(doLettersAndNumbersBruteForce(input)).isEqualTo(0);
    }

    @Test
    public void simpleTest3() {
        char a = 'a';
        char o = 1;
        char[] input = new char[]{o};
        assertThat(doLettersAndNumbers(input)).isEqualTo(0);
        assertThat(doLettersAndNumbersBruteForce(input)).isEqualTo(0);
    }

    //////////////
    // SOLUTION //
    //////////////

    /**
     * Time Complexity: O(n^2)
     *
     * @param a
     * @return
     */
    public int doLettersAndNumbersBruteForce(char[] a) {
        int N = a.length;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int digits = 0;
            int chars = 0;
            for (int j = i; j < N; j++) {
                if (isDigit(a[j])) digits++;
                else chars++;
            }
            max = Math.max(max, Math.min(digits, chars));
        }
        return max * 2;
    }

    /**
     * Time Complexity: O(n)
     *
     * @param a
     * @return
     */
    public int doLettersAndNumbers(char[] a) {
        int N = a.length;
        int[][] buffer = new int[N][2];
        int digits = 0;
        int chars = 0;
        for (int i = 0; i < N; i++) {
            if (isDigit(a[i]))
                digits++;
            else chars++;
            buffer[i][0] = digits;
            buffer[i][1] = chars;
        }
        Map<Integer, Integer> o = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int diff = buffer[i][0] - buffer[i][1];
            Integer position = o.get(diff);
            if (position == null) o.put(diff, i);
            else max = Math.max(i - position, max);
        }
        return max;
    }

    public boolean isDigit(char a) {
        return !Character.isLetter(a);
    }
}
