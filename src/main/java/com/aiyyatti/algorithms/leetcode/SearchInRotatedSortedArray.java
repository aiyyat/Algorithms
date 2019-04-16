package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * TODO: has numerous corner cases. Change the approach - to define the condititions around going left or right,
 *  rather than defining left or right around conditions.
 */
public class SearchInRotatedSortedArray {
    @Test
    public void case1Test() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        TestCase.assertEquals(1, search(input, 2));
    }

    @Test
    public void case2Test() {
        int[] input = {4, 5, 6, 7, 1, 2, 3};
        TestCase.assertEquals(5, search(input, 2));
    }

    @Test
    public void case3Test() {
        int[] input = new int[]{7, 1, 2, 3, 4, 5, 6};
        TestCase.assertEquals(2, search(input, 2));
    }

    @Test
    public void corner1Test() {
        int[] input = {1};
        TestCase.assertEquals(-1, search(input, 2));
    }

    @Test
    public void corner2Test() {
        int[] input = {2};
        TestCase.assertEquals(0, search(input, 2));
    }

    @Test
    public void corner3Test() {
        int[] input = {1, 2};
        TestCase.assertEquals(1, search(input, 2));
    }

    @Test
    public void corner4Test() {
        int[] input = {2, 1};
        TestCase.assertEquals(0, search(input, 2));
    }

    @Test
    public void corner5Test() {
        int[] input = {3, 1};
        TestCase.assertEquals(-1, search(input, 2));
    }

    @Test
    public void corner6Test() {
        int[] input = {1, 3};
        TestCase.assertEquals(-1, search(input, 2));
    }

    @Test
    public void corner7Test() {
        int[] input = {5, 1, 3};
        TestCase.assertEquals(0, search(input, 5));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        int mid = (start + end + 1) / 2;
        if (start > end) return -1;
        if (nums[mid] == target) return mid;
        else if ((nums[start] < nums[mid] && target >= nums[start] && target < nums[mid])
                || (nums[mid] < nums[end] && (target < nums[mid] || target > nums[end]))
                || mid == end) {
            return search(nums, target, start, mid - 1);
        } else {
            return search(nums, target, mid + 1, end);
        }
    }

}
