package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

public class MagicIndex {
    // CTCI Solution
    public int doMagicIndexBestSolution(int[] a, int start, int end) {
        if (end - 1 < start) return -1;
        int mid = (start + end) / 2;
        if (a[mid] == mid) return mid;
        int output = -1;
        output = doMagicIndexWithoutRepeatingNumbers(a, start, Math.min(a[mid], mid - 1));
        if (output == -1) output = doMagicIndexWithoutRepeatingNumbers(a, Math.max(a[mid], mid + 1), end);
        return output;
    }

    public int doMagicIndexWithRepeatingNumbers(int[] a, int start, int end) {
        if (end - 1 < start) return -1;
        int mid = (start + end) / 2;
        if (a[mid] == mid) return mid;
        int output = -1;
        if (a[mid] > mid && a[start] < mid) output = doMagicIndexWithoutRepeatingNumbers(a, start, mid);
        if (output == -1 && a[end - 1] >= end - 1) output = doMagicIndexWithoutRepeatingNumbers(a, mid + 1, end);
        return output;
    }

    public int doMagicIndexWithoutRepeatingNumbers(int[] a, int start, int end) {
        if (end - 1 < start) return -1;
        int mid = (start + end) / 2;
        if (a[mid] == mid) return mid;
        int output = -1;
        if (a[mid] > mid && a[start] <= start) output = doMagicIndexWithoutRepeatingNumbers(a, start, mid);
        if (output == -1 && a[end - 1] > mid) output = doMagicIndexWithoutRepeatingNumbers(a, mid + 1, end);
        return output;
    }


    //////////////
    //TEST CASES//
    //////////////
    @Test
    public void simpleBest1Test() {
        TestCase.assertEquals(5, doMagicIndexBestSolution(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simpleBest2Test() {
        TestCase.assertEquals(7, doMagicIndexBestSolution(new int[]{0, -1, -2, -3, 1, 2, 5, 7, 9, 19, 110}));
    }

    @Test
    public void simpleBest3Test() {
        TestCase.assertEquals(3, doMagicIndexBestSolution(new int[]{-2, -1, 1, 3, 6, 8, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simpleBest4Test() {
        TestCase.assertEquals(-1, doMagicIndexBestSolution(new int[]{-1, 2, 3, 6, 8, 16, 17, 18, 91, 110}));
    }

    @Test
    public void simpleBest5Test() {
        TestCase.assertEquals(2, doMagicIndexBestSolution(new int[]{-1, 2, 2, 6, 8, 16, 17, 18, 91, 110}));
    }

    @Test
    public void simpleBestRepeat1Test() {
        TestCase.assertEquals(5, doMagicIndexWithRepeatingNumbers(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simpleBestRepeat2Test() {
        TestCase.assertEquals(7, doMagicIndexWithRepeatingNumbers(new int[]{2, 2, 2, 2, 1, 2, 5, 7, 9, 19, 110}));
    }

    @Test
    public void simpleBestRepeat3Test() {
        TestCase.assertEquals(3, doMagicIndexWithRepeatingNumbers(new int[]{-2, -1, 1, 3, 6, 8, 6, 7, 7, 7, 7}));
    }

    @Test
    public void simpleBestRepeat4Test() {
        TestCase.assertEquals(-1, doMagicIndexWithRepeatingNumbers(new int[]{-1, 2, 3, 6, 8, 16, 17, 18, 91, 110}));
    }

    @Test
    public void simple1Test() {
        TestCase.assertEquals(5, doMagicIndexWithoutRepeatingNumbers(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simple2Test() {
        TestCase.assertEquals(7, doMagicIndexWithoutRepeatingNumbers(new int[]{0, -1, -2, -3, 1, 2, 5, 7, 9, 19, 110}));
    }

    @Test
    public void simple3Test() {
        TestCase.assertEquals(3, doMagicIndexWithoutRepeatingNumbers(new int[]{-2, -1, 1, 3, 6, 8, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simple4Test() {
        TestCase.assertEquals(-1, doMagicIndexWithoutRepeatingNumbers(new int[]{-1, 2, 3, 6, 8, 16, 17, 18, 91, 110}));
    }

    @Test
    public void simple5Test() {
        TestCase.assertEquals(2, doMagicIndexWithoutRepeatingNumbers(new int[]{-1, 2, 2, 6, 8, 16, 17, 18, 91, 110}));
    }

    @Test
    public void simpleRepeat1Test() {
        TestCase.assertEquals(5, doMagicIndexWithRepeatingNumbers(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void simpleRepeat2Test() {
        TestCase.assertEquals(7, doMagicIndexWithRepeatingNumbers(new int[]{2, 2, 2, 2, 1, 2, 5, 7, 9, 19, 110}));
    }

    @Test
    public void simpleRepeat3Test() {
        TestCase.assertEquals(3, doMagicIndexWithRepeatingNumbers(new int[]{-2, -1, 1, 3, 6, 8, 6, 7, 7, 7, 7}));
    }

    @Test
    public void simpleRepeat4Test() {
        TestCase.assertEquals(-1, doMagicIndexWithRepeatingNumbers(new int[]{-1, 2, 3, 6, 8, 16, 17, 18, 91, 110}));
    }


    public int doMagicIndexWithoutRepeatingNumbers(int[] a) {
        return doMagicIndexWithoutRepeatingNumbers(a, 0, a.length);
    }

    public int doMagicIndexWithRepeatingNumbers(int[] a) {
        return doMagicIndexWithRepeatingNumbers(a, 0, a.length);
    }

    public int doMagicIndexBestSolution(int[] a) {
        return doMagicIndexBestSolution(a, 0, a.length);
    }
}
