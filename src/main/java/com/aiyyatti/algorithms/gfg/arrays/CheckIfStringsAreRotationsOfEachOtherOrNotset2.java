package com.aiyyatti.algorithms.gfg.arrays;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/check-strings-rotations-not-set-2/
 */
public class CheckIfStringsAreRotationsOfEachOtherOrNotset2 {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        TestCase.assertTrue(checkIfStringsAreRotationsOfEachOtherOrNotset2("ABCD", "BCDA"));
    }
    @Test
    public void testSimple2() {
        TestCase.assertFalse(checkIfStringsAreRotationsOfEachOtherOrNotset2("ABCDE", "BCDA"));
    }

    public boolean checkIfStringsAreRotationsOfEachOtherOrNotset2(String a, String b) {
        return (a + a).indexOf(b) != -1;
    }
}
