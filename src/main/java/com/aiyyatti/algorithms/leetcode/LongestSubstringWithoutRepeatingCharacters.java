package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 * TODO: corner cases corner cases, Implementation is as follows: a HashMap is used to track the last occurance of a string.
 *        keep a pointer on the first of unique string, move the for loop index until you find a value in the hashmap.
 *        The value of index if greater(or after) the occurance of the unique pointer just update the pointer in hashmap
 *        else if it exists in the hashmap, calculate the unique until value and store in the length.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void straightTest() {
        TestCase.assertEquals(4, doLongestSubstringWithoutRepeatingCharacters("cbabcdbbaeaf"));
    }

    @Test
    public void leet1Test() {
        TestCase.assertEquals(3, doLongestSubstringWithoutRepeatingCharacters("abcabcbb"));
    }

    @Test
    public void leet2Test() {
        TestCase.assertEquals(1, doLongestSubstringWithoutRepeatingCharacters("bbbbb"));
    }

    @Test
    public void leet3Test() {
        TestCase.assertEquals(3, doLongestSubstringWithoutRepeatingCharacters("pwwkew"));
    }

    @Test
    public void cornerTest() {
        TestCase.assertEquals(1, doLongestSubstringWithoutRepeatingCharacters("b"));
    }

    @Test
    public void corner1Test() {
        TestCase.assertEquals(2, doLongestSubstringWithoutRepeatingCharacters("ba"));
    }

    /**
     * Leetcode method.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        return doLongestSubstringWithoutRepeatingCharacters(s);
    }

    /**
     * My Method.
     *
     * @param str
     * @return
     */
    int doLongestSubstringWithoutRepeatingCharacters(String str) {
        if (str == null || str.equals("")) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int uniqueFrom = 0;
        int max = 1;
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            Integer value = map.get(key);
            if (value != null && value >= uniqueFrom) {
                max = Math.max(i - uniqueFrom, max);
                uniqueFrom = value + 1;
            } else if (i == str.length() - 1) max = Math.max(i - uniqueFrom + 1, max);
            map.put(key, i);
        }
        return max;
    }
}
