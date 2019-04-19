package com.aiyyatti.algorithms.interviewing.recordings;

import junit.framework.TestCase;
import org.junit.Test;

public class SecondBiggestNumber {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple() {
        TestCase.assertEquals(1, secondBiggestNumber(new int[]{5, 4, 0, 6, 7, 9, 1, 7}));
    }
    @Test
    public void testSimple3() {
        int a[] = new int[]{5, 4, 0, 6, 7, 9, 1, 7};
        System.out.println(nThBiggestNumber(a,1));
        System.out.println(nThBiggestNumber(a,2));
        System.out.println(nThBiggestNumber(a,3));
        System.out.println(nThBiggestNumber(a,4));
        System.out.println(nThBiggestNumber(a,5));
        System.out.println(nThBiggestNumber(a,6));
        System.out.println(nThBiggestNumber(a,7));
    }

    @Test
    public void testSimple1() {
        TestCase.assertEquals(1, secondBiggestNumber(new int[]{5, 4, 1, 6, 7, 9, 0, 7}));
    }

    @Test
    public void testSimple2() {
        TestCase.assertEquals(3, secondBiggestNumber(new int[]{3, 2, 5, 6}));
    }

    private int secondBiggestNumber(int[] a) {
        int N = a.length;
        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (a[i] < min0) {
                min1 = min0;
                min0 = a[i];
            } else if (a[i] < min1) min1 = a[i];
        }
        return min1;
    }

    private void swap(int[] a, int i, int n) {
        int temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }

    private int nThBiggestNumber(int[] a, int n) {
        int N = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[n]) swap(a, i, n);
        }
        for (int i = n + 1; i < N; i++) {
            if (a[i] < a[n]) swap(a, i, n);
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > a[n]) swap(a, i, n);
        }
        return a[n];
    }
}
