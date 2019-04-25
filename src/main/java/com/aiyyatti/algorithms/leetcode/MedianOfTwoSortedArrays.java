package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO: Super Complicated.
 */
public class MedianOfTwoSortedArrays {
    @Test
    public void simple0Test() {
        int[] shorter = new int[]{1, 2, 3};
        int[] longer = new int[]{4, 5, 6};
        assertEquals(3.5, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple1Test() {
        int[] shorter = new int[]{1, 10, 20};
        int[] longer = new int[]{11, 12, 13, 14, 15};
        assertEquals(12.5, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple2Test() {
        int[] shorter = new int[]{1, 10, 20};
        int[] longer = new int[]{11, 12, 13, 14};
        assertEquals(12.0, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple3Test() {
        int[] shorter = new int[]{};
        int[] longer = new int[]{1};
        assertEquals(1.0, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple4Test() {
        int[] shorter = new int[]{};
        int[] longer = new int[]{1, 3};
        assertEquals(2.0, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple4_5Test() {
        int[] shorter = new int[]{};
        int[] longer = new int[]{1, 2, 3, 4, 5};
        assertEquals(3.0, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple4_6Test() {
        int[] shorter = new int[]{100000};
        int[] longer = new int[]{100001};
        assertEquals(100000.5, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple5Test() {
        int[] shorter = new int[]{2};
        int[] longer = new int[]{1, 3};
        assertEquals(2.0, doMedianOfTwoSortedArrays(shorter, longer));
    }

    @Test
    public void simple6Test() {
        int[] shorter = new int[]{};
        int[] longer = new int[]{1, 2, 3, 4};
        assertEquals(2.5, doMedianOfTwoSortedArrays(shorter, longer));
    }

    public double doMedianOfTwoSortedArrays(int[] a1, int[] a2) {
        return a2.length > a1.length ? doMedianOfTwoSortedArraysShortLong(a1, a2) : doMedianOfTwoSortedArraysShortLong(a2, a1);
    }

    @Test
    public void simpleTest1() {
        doMedianOfTwoSortedArraysShortLong(new int[]{10, 20, 30}, new int[]{1, 2, 15, 25, 27, 29, 32});
        doMedianOfTwoSortedArraysShortLong(new int[]{}, new int[]{1, 2, 3, 4, 5});
        doMedianOfTwoSortedArraysShortLong(new int[]{10, 20}, new int[]{2, 3, 15});
        doMedianOfTwoSortedArraysShortLong(new int[]{10, 20, 30}, new int[]{1, 2, 3});
        doMedianOfTwoSortedArraysShortLong(new int[]{1, 2, 3}, new int[]{10, 20, 30});
    }

    public double doMedianOfTwoSortedArraysShortLong(int[] a, int[] b) {
        int aN = a.length - 1;
        int bN = b.length - 1;
        boolean even = 0 == ((aN + bN) % 2.0);
        int mid = (aN + bN) / 2;
        int aS = Math.min(mid, aN);
        int bS = (mid - aS);
        int asAMax = aS < 0 ? Integer.MIN_VALUE : a[aS];
        int bsAMax = bS <= 0 ? Integer.MIN_VALUE : b[bS - 1];
        int asBMin = Integer.MAX_VALUE;
        // To handle the {} {1} case. a better way to handle this?
        if (bN == 0 && bS > 0) return b[0];
        int bsBMin = b[bS];
        int aMax = Math.max(asAMax, bsAMax);
        int bMin = Math.min(bsBMin, asBMin);
        while (aMax > bMin) {
            aS--;
            bS++;
            asAMax = aS < 0 ? Integer.MIN_VALUE : a[aS];
            bsAMax = bS <= 0 ? Integer.MIN_VALUE : b[bS - 1];
            asBMin = aS < -1 ? Integer.MAX_VALUE : a[aS + 1];
            bsBMin = bS > bN ? Integer.MAX_VALUE : b[bS];
            aMax = Math.max(asAMax, bsAMax);
            bMin = Math.min(bsBMin, asBMin);
            System.out.printf("A:%s,%s  B:%s,%s\n", asAMax, bsAMax, asBMin, bsBMin);
        }
        System.out.printf("A:%s  B:%s\n", aMax, bMin);
        System.out.println("------------------");
        return even ? (aMax + bMin) / 2.0 : bMin;
    }
}
