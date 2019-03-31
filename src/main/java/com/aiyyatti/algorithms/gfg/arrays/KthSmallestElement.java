package com.aiyyatti.algorithms.gfg.arrays;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 */
public class KthSmallestElement {
    @Test
    public void simpleTest() {
        int[] a = {9, 7, 8, 2, 5, 1, 3, 6, 4, 0};
        for (int i = 0; i < a.length; i++) TestCase.assertEquals(i, doKthSmallestElement(a.clone(), i));
    }

    public int doKthSmallestElement(int[] a, int K) {
        return doKthSmallestElement(a, 0, a.length - 1, K);
    }

    public int doKthSmallestElement(int[] a, int start, int end, int K) {
        int right = end;
        int left = start;
        int pivot = left;
        left++;
        while (true) {
            while (left < end && a[left] < a[pivot]) left++;
            while (right > 0 && a[right] > a[pivot]) right--;
            if (left > right) break;
            swap(a, left, right);
            left++;
            right--;
        }
        left = Math.min(left, end);  // left might be greater than end
        swap(a, left, pivot); // since pivot is first always exchange with left

        if (K < left) return doKthSmallestElement(a, start, left - 1, K);
        else if (K > left) return doKthSmallestElement(a, left + 1, end, K);
        return left;
    }

    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
