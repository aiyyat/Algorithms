package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class LongestWord {
    private static final Logger logger = getLogger(LongestWord.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        System.out.println(findLongestWord(new String[]{"awesomeness", "awesome", "awe", "do", "straw", "mice", "so", "me"}));
    }

    //////////////
    // SOLUTION //
    //////////////
    public String findLongestWord(String[] a) {
        Arrays.sort(a, (x, y) -> x.length() - y.length());
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < a.length; i++) dict.add(a[i]);
        int N = a.length;
        for (int i = N - 1; i >= 0; i--) {
            dict.remove(a[i]);
            if (findLongestWord(a[i], dict)) return a[i];
        }
        return null;
    }

    public boolean findLongestWord(String word, Set<String> dict) {
        int N = word.length();
        if (N == 0) return true;
        logger.debug(word);
        for (int i = N - 1; i >= 0; i--) {
            String left = word.substring(0, i + 1);
            String right = word.substring(i + 1, N);
            logger.debug("left:{} contains: {}    right:{}", left, dict.contains(left), right);
            if (dict.contains(left) && findLongestWord(right, dict)) {
                return true;
            }
        }
        return false;
    }
}
