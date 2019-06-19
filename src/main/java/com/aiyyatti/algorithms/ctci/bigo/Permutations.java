package com.aiyyatti.algorithms.ctci.bigo;

import junit.framework.TestCase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;

import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class Permutations {
    private static final Logger logger = getLogger(Permutations.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @ParameterizedTest
    @MethodSource("permutations")
    public void testSimple(String inputs, int output) {
        TestCase.assertEquals(output, doPermutations(inputs, inputs.length() - 1));
    }

    private static Stream permutations() {
        return Stream.of(
                Arguments.of("abcd", 24),
                Arguments.of("abc", 6)
        );
    }

    //////////////
    // SOLUTION //
    //////////////
    int doPermutations(String str, int index) {
        if (index == 0) {
            System.out.println(str);
            return 1;
        }
        int output = 0;
        for (int j = 0; j <= index; j++) {
            char ch = str.charAt(j);
            String newStr = str.substring(0, j) + str.substring(j + 1) + ch;
            output += doPermutations(newStr, index - 1);
        }
        return output;
    }
}
