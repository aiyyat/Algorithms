package com.aiyyatti.algorithms.leetcode;

import org.junit.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: https://leetcode.com/problems/gas-station/
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class GasStation {
    private static final Logger logger = getLogger(GasStation.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testGasStation() {
        System.out.println(findGasStation(new int[][]{
                new int[]{1, 3},
                new int[]{2, 4},
                new int[]{3, 5},
                new int[]{4, 1},
                new int[]{5, 2}
        }));
    }

    //////////////
    // SOLUTION //
    //////////////
    final private int GAS = 0;
    final private int DIST = 1;

    public int findGasStation(int[][] milestones) {
        int N = milestones.length;
        nextmilestone:
        for (int j = 0; j < N; j++) {
            int balance = 0;
            for (int i = 0; i < N; i++) {
                int a = (i + j) % N;
                balance += milestones[a][GAS] - milestones[a][DIST];
                if (balance < 0) continue nextmilestone;
            }
            return j;
        }
        return -1;
    }
}
