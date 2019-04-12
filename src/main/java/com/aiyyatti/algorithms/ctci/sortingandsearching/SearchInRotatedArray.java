package com.aiyyatti.algorithms.ctci.sortingandsearching;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO: Tricky implementation, corner case check
 * fails case: [3,1] 1
 *
 */
public class SearchInRotatedArray {
    @Test
    public void test1Simple() {
        int[] sortRotatad = new int[]{4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, search(sortRotatad, 4));
    }

    @Test
    public void test3Simple() {
        int[] sortRotatad = new int[]{4, 5, 6, 7, 0, 1, 2};
        assertEquals(2, search(sortRotatad, 6));
    }

    @Test
    public void test2Simple() {
        int[] sortRotatad = new int[]{4, 5, 6, 7, 0, 1, 2};
        assertEquals(-1, search(sortRotatad, 3));
    }

    @Test
    public void test23Simple() {
        int[] sortRotatad = new int[]{4, 5, 6, 7, 0, 1, 2};
        assertEquals(4, search(sortRotatad, 0));
    }

    @Test
    public void test7Simple() {
        int[] sortRotatad = new int[]{1, 3};
        assertEquals(-1, search(sortRotatad, 4));
    }

    @Test
    public void test6Simple() {
        int[] sortRotatad = new int[]{1};
        assertEquals(-1, search(sortRotatad, 2));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[start] < nums[mid]) {
            if (target >= nums[start] && target <= nums[mid]) end = mid - 1;
            else start = mid + 1;
        } else {
            if (target >= nums[mid] && target <= nums[end]) start = mid + 1;
            else end = mid - 1;
        }
        return search(nums, target, start, end);
    }
}
