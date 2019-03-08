package com.aiyyatti.algorithms.misc.companies.aws;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The two sum problem is a common interview question,
 * and it is a variation of the subset sum problem.
 * There is a popular dynamic programming solution for the subset
 * sum problem, but for the two sum problem we can actually
 * write an algorithm that runs in O(n) time.
 * The challenge is to find all the pairs of two integers in an unsorted
 * array that sum up to a given S.
 * <p>
 * For example,
 * if the array is [3, 5, 2, -4, 8, 11] and the sum is 7,
 * your program should return [[11, -4], [2, 5]] because 11 + -4 = 7 and 2 + 5 = 7.
 */
public class TwoSumProblem {
    private Logger logger = LoggerFactory.getLogger(TwoSumProblem.class);
    private final Integer ZERO = 0;

    public List<ArrayList<Integer>> doTwoSum(int[] a, int N) {
        List<ArrayList<Integer>> output = new ArrayList<>();
        HashMap<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            values.put(a[i], values.getOrDefault(a[i], ZERO) + 1);
        }
        for (int i = 0; i < a.length; i++) {
            int key = N - a[i];
            Integer pair = values.get(key);
            if (pair != null && pair > 0) {
                ArrayList<Integer> val = new ArrayList<>();
                val.add(a[i]);
                val.add(key);
                output.add(val);
                values.put(key, pair - 1);
                values.put(a[i], pair - 1);
            }
        }
        return output;
    }

    @Test
    public void testSimple() {
        logger.info("Output: {}", doTwoSum(new int[]{3, 5, 2, -4, 8, 11}, 7));
    }
}
