package com.aiyyatti.algorithms.misc.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * <p>
 * TODO: redo took a lot of time.
 */
public class KnapSack {
    private Logger logger = LoggerFactory.getLogger(KnapSack.class);

    /////////////////
    // WITH MATRIX //
    /////////////////

    /**
     * Time Complexity: O(v*W) where v is the number of values and W is the weight.
     *
     * @param value
     * @param weight
     * @param W
     * @return
     */
    public int findBestValueWithMatrix(int[] value, int[] weight, int W) {
        int MAX_ROW = weight.length + 1;
        int MAX_COL = W + 1;
        int[][] valueMatrix = new int[MAX_ROW][MAX_COL];
        for (int row = 1; row < MAX_ROW; row++) {
            for (int column = 1; column < MAX_COL; column++) {
                if (weight[row - 1] > column) valueMatrix[row][column] = valueMatrix[row - 1][column];
                else
                    valueMatrix[row][column] = Math.max(value[row - 1] + valueMatrix[row - 1][column - weight[row - 1]],
                            valueMatrix[row - 1][column]);
            }
        }
        return valueMatrix[MAX_ROW - 1][MAX_COL - 1];
    }

    //////////////////////////
    // WITHOUT MEMONIZATION //
    //////////////////////////
    public int findBestValueWithoutMemonization(int[] value, int[] weight, int W) {
        return findBestValueWithoutMemonization(0, 0, 0, value, weight, W, "");
    }

    /**
     * TimeComplexity: O(v!) where v is the number of values.
     *
     * @param index
     * @param weightTillNow
     * @param valueTillNow
     * @param value
     * @param weight
     * @param W
     * @param input
     * @return
     */
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
            //logger.debug("Series: {} Permissible Weight: {} Best Total(in order): {}", seriesString, W, maxValue);
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
        TestCase.assertEquals(220, findBestValueWithoutMemonization(value, weight, W));
        TestCase.assertEquals(220, findBestValueWithMatrix(value, weight, W));
    }

    @Test
    public void simpleTest2() {
        int[] value = new int[]{10, 40, 30, 50};
        int[] weight = new int[]{5, 4, 6, 3};
        int W = 10;
        TestCase.assertEquals(90, findBestValueWithoutMemonization(value, weight, W));
        TestCase.assertEquals(90, findBestValueWithMatrix(value, weight, W));

    }

    @Test
    public void simpleTest3() {
        int[] value = new int[]{24, 18, 18, 10};
        int[] weight = new int[]{24, 10, 10, 7};
        int W = 25;
        TestCase.assertEquals(36, findBestValueWithoutMemonization(value, weight, W));
        TestCase.assertEquals(36, findBestValueWithMatrix(value, weight, W));
    }

    /**
     * This wouldn't work with the Combination method.
     */
    @Test
    public void simpleTest4() {
        int[] value = new int[]{1, 4, 2, 5, 7, 9, 0, 2, 1, 3, 6, 8, 0, 0, -2, 1, 3, 1, 2, 7, 9, 0, 7, 5, 4, 3, 3, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 9, 3, 2, 1, 1, 2, 4, 5, 6, 7, 8, 9, 0, 2, 1, 1, 1};
        int[] weight = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
        int W = 345;
        // TestCase.assertEquals(119, findBestValueWithoutMemonization(value, weight, W));
        TestCase.assertEquals(119, findBestValueWithMatrix(value, weight, W));
    }
}
