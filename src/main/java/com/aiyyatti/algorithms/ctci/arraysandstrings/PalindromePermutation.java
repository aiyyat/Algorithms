package com.aiyyatti.algorithms.ctci.arraysandstrings;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

/**
 * TODO: you can also use the bit operation if the strings are just a to z.
 */
public class PalindromePermutation {
    ////////////////
    // TEST CASES //
    ////////////////
    @ParameterizedTest
    @MethodSource("palindrome")
    public void check(String word, boolean result) {
        assertThat(checkPalindromePermutationWithDS(word)).isEqualTo(result);
        assertThat(checkPalindromePermutationWithBit(word)).isEqualTo(result);
    }

    static Stream palindrome() {
        return Stream.of(
                Arguments.of("mmaalaaly", true),
                Arguments.of("mmaalaalya", false),
                Arguments.of("m", true),
                Arguments.of("mm", true),
                Arguments.of("mmm", true)
        );
    }

    @Test
    public void simple1Test() {
        assertTrue(checkPalindromePermutationWithDS("Tact Coa"));
    }

    @Test
    public void simple2Test() {
        assertFalse(checkPalindromePermutationWithDS("Tact Coa a"));
    }

    @Test
    public void simple3Test() {
        assertTrue(checkPalindromePermutationWithBit("Tact Coa"));
    }

    @Test
    public void simple4Test() {
        assertFalse(checkPalindromePermutationWithBit("Tact Coa a"));
    }

    public boolean checkPalindromePermutationWithBit(String str) {
        char[] a = str.toLowerCase().replaceAll(" ", "").toCharArray();
        int N = a.length;
        int bity = 0;
        for (int i = 0; i < N; i++) {
            int pos = a[i] - 'a';
            int mask = 1 << pos;
            if ((mask & bity) == 0) bity |= mask;
            else bity &= ~mask;
        }
        return 0 == (bity & bity - 1);
    }

    public boolean checkPalindromePermutationWithDS(String str) {
        char[] a = str.toLowerCase().replaceAll(" ", "").toCharArray();
        int[] count = new int[26];
        int N = a.length;
        int odd = 0;
        for (int i = 0; i < N; i++) {
            int index = a[i] - 'a';
            count[index]++;
            if (count[index] % 2 != 0) odd++;
            else odd--;
        }
        return odd == 1 || odd == 0;
    }
}
