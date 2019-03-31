package com.aiyyatti.algorithms.ctci.bitmanipulation;

import org.junit.Test;

/**
 * 1	0	1	1	1	0	1	1	1	0	1	1	1	0	1	1	1	1	0	1	1	1	1	0	0	1
 * CTN	1	2	3	4	5	4	5	6	7	4	5	6	7	4	5	6	7	8	5	6	7	8	9	5	1	2
 * CSZ	1	0	1	2	3	0	1	2	3	0	1	2	3	0	1	2	3	4	0	1	2	3	4	0	0	1
 */
public class FlipBitToWin {
    @Test
    public void testSimple() {
        System.out.println(doFlipBitToWin(1775));
    }

    public int doFlipBitToWin(int a) {
        int countWithOneZero = 0;
        int countOfOnes = 0;
        int maxBit = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(a));
        while (a != 0) {
            int bit = a & 1;
            if (bit == 0) {
                maxBit = Math.max(countWithOneZero, maxBit);
                countWithOneZero = countOfOnes + 1;
                countOfOnes = 0;
            } else {
                countWithOneZero++;
                countOfOnes++;
            }
            a = a >>> 1;
        }
        return maxBit;
    }
}
