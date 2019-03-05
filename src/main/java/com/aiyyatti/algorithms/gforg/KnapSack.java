package com.aiyyatti.algorithms.gforg;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KnapSack {
    Logger logger = LoggerFactory.getLogger(KnapSack.class);

    //////////////////////////
    // WITHOUT MEMONIZATION //
    //////////////////////////
    public int findBestValueWithoutMemonization(int[] value, int[] weight, int W) {
        return findBestValueWithoutMemonization(0, 0, 0, value, weight, W, "");
    }

    public int findBestValueWithoutMemonization(int index, int weightTillNow, int valueTillNow, int[] value, int[] weight, int W, String input) {
        if (index > weight.length) return 0;
        int maxValue = valueTillNow;
        for (int i = index; i < weight.length; i++) {
            int newWeightTillNow = weightTillNow + weight[i];
            String seriesString = String.format("%s %s(%s)", input, weight[i], value[i]);
            int localSumOfSeries = valueTillNow;
            if (newWeightTillNow <= W) {
                localSumOfSeries = findBestValueWithoutMemonization(i + 1, newWeightTillNow, localSumOfSeries + value[i], value, weight, W, seriesString);
            }
            maxValue = Math.max(localSumOfSeries, maxValue);
            logger.debug("Series: {} Permissible Weight: {} Best Total(in order): {}", seriesString, W, maxValue);
        }
        return maxValue;
    }

    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void simpleTest1() {
        int[] value = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        int W = 50;
        int[][] table = new int[value.length + 1][weight.length + 1];
        TestCase.assertEquals(220, findBestValueWithoutMemonization(value, weight, W));
    }

    @Test
    public void simpleTest2() {
        int[] value = new int[]{10, 40, 30, 50};
        int[] weight = new int[]{5, 4, 6, 3};
        int W = 10;
        int[][] table = new int[value.length + 1][weight.length + 1];
        TestCase.assertEquals(90, findBestValueWithoutMemonization(value, weight, W));
    }

    @Test
    public void simpleTest3() {
        int[] value = new int[]{24, 18, 18, 10};
        int[] weight = new int[]{24, 10, 10, 7};
        int W = 25;
        int[][] table = new int[value.length + 1][weight.length + 1];
        TestCase.assertEquals(36, findBestValueWithoutMemonization(value, weight, W));
    }
}