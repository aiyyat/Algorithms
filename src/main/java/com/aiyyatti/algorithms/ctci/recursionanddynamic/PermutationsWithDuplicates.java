package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * No Asserting for simple problems.
 */
public class PermutationsWithDuplicates {
    //////////////
    // TESTCASE //
    //////////////
    @Test
    public void simpleTest() {
        assertEquals("[aabb, abab, abba, baab, baba, bbaa]", doPermutationsWithDuplicates("aabb", 0).toString());
    }

    public ArrayList<String> doPermutationsWithDuplicates(String str, int index) {
        Map<Character, Integer> freq = new HashMap<>();
        int N = str.length();
        for (int i = 0; i < N; i++) {
            Character ith = str.charAt(i);
            int count = freq.getOrDefault(ith, 0);
            freq.put(ith, count + 1);
        }
        return doPermWithDups("", freq, N);
    }

    private ArrayList<String> doPermWithDups(String prefix, Map<Character, Integer> freq, int N) {
        ArrayList<String> output = new ArrayList<>();
        if (prefix.length() == N) {
            output.add(prefix);
            return output;
        }
        for (Character c : freq.keySet()) {
            int count = freq.get(c);
            if (count > 0) {
                freq.put(c, count - 1);
                output.addAll(doPermWithDups(prefix + c, freq, N));
                freq.put(c, count);
            }
        }
        return output;
    }
}
