package com.aiyyatti.algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest() {
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int N = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else zeroCount++;
        }
        int[] output = new int[N];
        if (zeroCount > 1)
            for (int i = 0; i < N; i++) output[i] = 0;
        else if (zeroCount == 1)
            for (int i = 0; i < N; i++)
                if (nums[i] == 0) output[i] = product;
                else output[i] = 0;
        else for (int i = 0; i < N; i++) output[i] = product / nums[i];
        return output;
    }
}
