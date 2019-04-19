package com.aiyyatti.algorithms.gfg.aws;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all duplicates in an array in linear time (v1)
 * This is a common interview question where you need to write a program to find all duplicates in an array where the numbers in the array are in the range of 0 to n-1 where n is the size of the array. For example: [1, 2, 3, 3] is okay but [1, 2, 6, 3] is not. In this version of the challenge there can be multiple duplicate numbers as well.
 * <p>
 * The algorithm below is commented to explain what each piece of code does, but the general algorithm is:
 * <p>
 * (1) Loop through the array
 * (2) For each element, find array[absolute(array[i])] in the array and set its value to negative if positive
 * (3) If in step 2 you encounter a negative number, then it means the element at index i in the array is a duplicate
 */
public class DuplicatesInAnArrayInLinearTime {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Integer[] arr = new Integer[]{1, 2, 2, 3, 1};
        TestCase.assertEquals("[2, 1]", Arrays.toString(doDuplicatesInAnArrayInLinearTime(arr)));
    }

    @Test
    public void simpleTest2() {
        Integer[] arr = new Integer[]{1, 2, 4, 5, 6, 7, 8, 9, 0, 7, 4, 2, 6, 8, 9, 1};
        TestCase.assertEquals("[7, 4, 2, 6, 9, 1]", Arrays.toString(doDuplicatesInAnArrayInLinearTime(arr)));
    }

    public Integer[] doDuplicatesInAnArrayInLinearTime(Integer[] a) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int absValue = Math.abs(a[i]);
            if (a[absValue] < 0) {
                duplicates.add(absValue);
            } else {
                a[absValue] *= -1;
            }
        }
        return duplicates.stream().toArray(Integer[]::new);
    }
}
