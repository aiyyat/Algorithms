package com.aiyyatti.algorithms.ctci.hard;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * TODO: Revise logic.
 * Note: it works well with negative numbers as well.
 */
public class AddWithoutPlus {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void ctciTest() {
        TestCase.assertEquals(1406, doAddWithoutPlus(759, 647));
    }

    public void simple1Test() {
        TestCase.assertEquals(12, doAddWithoutPlus(7, 5));
    }

    @Test
    public void simple2Test() {
        TestCase.assertEquals(-2, doAddWithoutPlus(-7, 5));
    }

    @Test
    public void simple3Test() {
        TestCase.assertEquals(2, doAddWithoutPlus(7, -5));
    }

    @Test
    public void simple5Test() {
        TestCase.assertEquals(-12, doAddWithoutPlus(-7, -5));
    }

    @Test
    public void simple4Test() {
        TestCase.assertEquals(7, doAddWithoutPlus(7, 0));
    }

    public int doAddWithoutPlus(int num1, int num2) {
        int sumWithoutCarry = num1 ^ num2;
        int carryWithoutSum = (num1 & num2) << 1;
        while (carryWithoutSum != 0) {
            int tempSumWithoutCarry = sumWithoutCarry ^ carryWithoutSum;
            int tempCarryWithoutSum = (sumWithoutCarry & carryWithoutSum) << 1;
            sumWithoutCarry = tempSumWithoutCarry;
            carryWithoutSum = tempCarryWithoutSum;
        }
        return sumWithoutCarry;
    }
}
