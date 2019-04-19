package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class LongestWord {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        System.out.printf("Matched: %s",doLongestWord(new String[]{"Sun", "Flower", "SunFlower"}));
    }

    public String doLongestWord(String[] strings) {
        Arrays.sort(strings, (String s1, String s2) -> s2.length() - s1.length());
        int N = strings.length;
        HashMap<String, Boolean> dict = new HashMap<>();
        for (String string : strings) dict.put(string, true);
        for (String string : strings) {
            if (doLongestWord(string, true, dict)) return string;
        }
        return null;
    }

    public boolean doLongestWord(String toSearch, boolean isOriginal, HashMap<String, Boolean> dict) {
        if (!isOriginal) {
            if (dict.containsKey(toSearch)) return dict.get(toSearch);
            else dict.put(toSearch, false);
        }
        System.out.println(toSearch);
        int N = toSearch.length();
        boolean output = false;
        for (int i = 1; i < N; i++) {
            String left = toSearch.substring(0, i);
            String right = toSearch.substring(i);
            if (doLongestWord(left, false, dict) & doLongestWord(right, false, dict)) {
                return true;
            }
        }
        return false;
    }
}
