package com.aiyyatti.algorithms.gfg.amazonsaskedinterviewquestions;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    ///////////////
    // TEST CASE //
    ///////////////
    @ParameterizedTest
    @MethodSource("mws")
    public void leetTest(String word, String sub, String expected) {
        assertThat(findMinimumWindowSubstring(word, sub)).isEqualTo(expected);
    }

    static Stream mws() {
        return Stream.of(
                Arguments.of("eadeefdcacdfedfdfe", "edca", "efdca"),
                Arguments.of("geeksforgeeks", "ork", "ksfor"),
                Arguments.of("geeksforgeeks", "crack", ""),
                Arguments.of("aaad", "d", "d"),
                Arguments.of("aaad", "a", "a")
        );
    }

    //////////////
    // SOLUTION //
    //////////////
    public String findMinimumWindowSubstring(String str, String sub) {
        char[] a = str.toCharArray();
        char[] b = sub.toCharArray();
        int[] freq = freq(b);
        int[] actual = new int['z' - 'a'];
        int end = 0, start = 0;
        String nextMatch = null, bestMatch = null;
        while (true) {
            System.out.println("before end adj");
            System.out.println("\t" + str.substring(start, end + 1));
            System.out.println("\t" + Arrays.toString(freq));
            System.out.println("\t" + Arrays.toString(actual));
            end = findMatchEnd(end, a, freq, actual);
            if (end == -1) return bestMatch;
            else bestMatch = min(bestMatch, str.substring(start, end + 1));
            System.out.println("after end adj");
            System.out.println("\t" + str.substring(start, end + 1));
            System.out.println("\t" + Arrays.toString(freq));
            System.out.println("\t" + Arrays.toString(actual));

            System.out.println("before Start adj");
            System.out.println("\t" + str.substring(start, end + 1));
            System.out.println("\t" + Arrays.toString(freq));
            System.out.println("\t" + Arrays.toString(actual));
            start = makeOneMismatch(start, a, freq, actual);
            System.out.println("after Start adj");
            System.out.println("\t" + str.substring(start-1, end + 1));
            System.out.println("\t" + Arrays.toString(freq));
            System.out.println("\t" + Arrays.toString(actual));

            bestMatch = min(bestMatch, str.substring(start-1, end + 1));
        }
    }

    public String min(String a, String b) {
        if (a == null) return b;
        if (b == null || a.length() < b.length()) return a;
        else return b;
    }

    @Test
    public void testMakeOneMismatch() {
        System.out.println(makeOneMismatch(0, "fdcacdfe".toCharArray(), new int[]{1, 0, 1, 1, 1, 0}, new int[]{1, 0, 2, 2, 1, 0}));
    }

    private int makeOneMismatch(int start, char[] a, int[] freq, int[] actual) {
        while (true) {
            if (freq[pos(a[start])] > 0) {
                actual[pos(a[start])]--;
                if (!containsAll(freq, actual)) {
                    return start + 1;
                }
            }
            start++;
        }
    }

    private int findMatchEnd(int end, char[] a, int[] freq, int[] actual) {
        int N = a.length;
        end++;
        while (end < N) {
            System.out.println("new end"+end);
            if (freq[pos(a[end])] > 0) actual[pos(a[end])]++;
            if (containsAll(freq, actual)) return end;
            end++;
        }
        System.out.println("No match found..");
        return -1;
    }

    private boolean containsAll(int[] freq, int[] actual) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > actual[i]) return false;
        }
        return true;
    }

    private int[] freq(char[] b) {
        int[] output = new int['z' - 'a'];
        for (int i = 0; i < b.length; i++) {
            output[pos(b[i])]++;
        }
        return output;
    }

    private int pos(char ch) {
        return ch - 'a';
    }
}
