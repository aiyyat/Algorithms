package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO two ways to do it. go thru both.
 */
public class PermutationsWithoutDups {
    ////////////
    //TEST CASE//
    ////////////
    @Test
    public void simpleCtciApproachTest1() {
        String str = "abc";
        assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest3() {
        String str = "ab";
        assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest4() {
        String str = "a";
        assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest2() {
        String str = "abcdefgh";
        assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    public int factorial(String str) {
        return factorial(str.length());
    }

    public int factorial(int a) {
        if (a == 0) return 1;
        else return a * factorial(a - 1);
    }

    public ArrayList<String> doPermutationsWithoutDupsCtci(String str) {
        return doPermutationsWithoutDupsCtci(str, 0);
    }

    /**
     * Always making the mistake of not going till the end to find the unique value to be added to the arraylist.
     * Time Complexity: O(N!)
     *
     * @param str
     * @param index
     * @return
     */
    public ArrayList<String> doPermutationsWithoutDupsCtci(String str, int index) {
        ArrayList<String> output = new ArrayList<String>();
        int N = str.length();
        if (index == N) {
            output.add(str);
            return output;
        }
        for (int i = index; i < N; i++) {
            char ith = str.charAt(i);
            // or substring of 0 to i and put ith in the end?
            output.addAll(doPermutationsWithoutDupsCtci(str.substring(0, i) + ith + str.substring(i + 1), index + 1));
        }
        return output;
    }
}
