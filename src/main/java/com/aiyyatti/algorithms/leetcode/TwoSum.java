package com.aiyyatti.algorithms.leetcode;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        int[] a = nums.clone();
        sort(a);
        int start = 0;
        int N = a.length;
        int end = N - 1;
        while (true) {
            int sum = a[start] + a[end];
            if (sum == target) {
                int output[] = new int[2];
                for (int offset = 0, i = 0; i < N && offset < 2; i++) {
                    if (nums[i] == a[start] || nums[i] == a[end]) output[offset++] = i;
                }
                return output;
            } else if (sum < target) start++;
            else if (sum > target) end--;
            else if (start > end) return null;
        }

    }
}