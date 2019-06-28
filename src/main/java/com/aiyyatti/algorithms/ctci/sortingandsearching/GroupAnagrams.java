package com.aiyyatti.algorithms.ctci.sortingandsearching;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class GroupAnagrams {
    @Test
    public void simpleTest() {
        String[] strings = {"army", "mary", "mate", "team", "bend", "said", "note", "tone"};
        assertEquals("[said, note, tone, bend, mate, team, army, mary]", Arrays.toString(doGroupAnagram(strings)));
    }

    public String[] doGroupAnagram(String[] words) {
        HashMap<String, ArrayList<String>> table = new HashMap<>();
        for (String word : words) {
            String charSort = charSort(word);
            ArrayList<String> group = table.getOrDefault(charSort, new ArrayList<>());
            group.add(word);
            table.put(charSort, group);
        }
        int offset = 0;
        for (String key : table.keySet()) {
            for (String word : table.get(key)) {
                words[offset++] = word;
            }
        }
        return words;
    }

    public String charSort(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
