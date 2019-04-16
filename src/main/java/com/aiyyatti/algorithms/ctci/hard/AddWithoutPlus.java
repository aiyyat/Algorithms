package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

/**
 * TODO: must revise the logic.
 */
public class AddWithoutPlus {
    @Test
    public void ctciTest() {
        System.out.println(doAddWithoutPlus(759, 674));
    }

    public int doAddWithoutPlus(int num1, int num2) {
        // num1 ^ num2 - sum without carry
        // num1 & numb2 - carry whhout sum
        int carry = 0;
        int sumWithoutCarry = 0;
        do {
            sumWithoutCarry = num1 ^ num2;
            carry = num1 & num2;
            num1 = sumWithoutCarry;
            num2 = carry << 1;
        } while (carry != 0);
        return sumWithoutCarry;
    }
}
