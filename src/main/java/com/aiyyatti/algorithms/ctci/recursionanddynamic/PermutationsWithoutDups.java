package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * TODO two ways to do it. go thru both.
 */
public class PermutationsWithoutDups {
    ////////////
    //TEST CASE//
    ////////////
    @Test
    public void simpleNonCtciApproachTest1() {
        String str = "abc";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsNonCtci(str).size());
    }

    @Test
    public void simpleNonCtciApproachTest3() {
        String str = "ab";
        ArrayList<String> output = doPermutationsWithoutDupsNonCtci(str);
        System.out.println(output);
        TestCase.assertEquals(factorial(str), output.size());
    }

    @Test
    public void simpleNonCtciApproachTest4() {
        String str = "a";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsNonCtci(str).size());
    }

    @Test
    public void simpleNonCtciApproachTest2() {
        String str = "abcdefgh";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsNonCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest1() {
        String str = "abc";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest3() {
        String str = "ab";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest4() {
        String str = "a";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    @Test
    public void simpleCtciApproachTest2() {
        String str = "abcdefgh";
        TestCase.assertEquals(factorial(str), doPermutationsWithoutDupsCtci(str).size());
    }

    public int factorial(String str) {
        return factorial(str.length());
    }

    public int factorial(int a) {
        if (a == 0) return 1;
        else return a * factorial(a - 1);
    }

    public ArrayList<String> doPermutationsWithoutDupsNonCtci(String str) {
        return doPermutationsWithoutDupsNonCtci(str, 0);
    }

    public ArrayList<String> doPermutationsWithoutDupsCtci(String str) {
        return doPermutationsWithoutDupsNonCtci(str, 0);
    }

    /**
     * Time Complexity: O(N!)
     *
     * @param str
     * @param index
     * @return
     */
    public ArrayList<String> doPermutationsWithoutDupsCtci(String str, int index) {
        ArrayList<String> output = new ArrayList<>();
        int N = str.length();
        if (index == N) return output;
        for (int i = 0; i < N; i++) {
            char ch = str.charAt(i);
            ArrayList<String> intermediateOutputs = doPermutationsWithoutDupsCtci(str, index + 1);
            for (String intermediateOutput : intermediateOutputs) {
                for (int j = 0; j < intermediateOutput.length(); i++) {
                    output.add(intermediateOutput.substring(0, j) + ch + intermediateOutput.substring(j + 1));
                }
            }
        }
        return output;
    }

    /**
     * TODO: Always making the mistake of not going till the end to find the unique value to be added to the arraylist.
     * TimeComplexity: O(N!)
     *
     * @param str
     * @param index
     * @return
     */
    public ArrayList<String> doPermutationsWithoutDupsNonCtci(String str, int index) {
        ArrayList<String> output = new ArrayList<>();
        if (index == str.length() - 1) {
            output.add(str);
            return output;
        }
        int N = str.length();
        for (int i = index; i < N; i++) {
            output.addAll(doPermutationsWithoutDupsNonCtci(str, index + 1));
            str = str.substring(0, index) + str.substring(index + 1) + str.charAt(index);
        }
        return output;
    }

}
