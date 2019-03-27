package com.aiyyatti.algorithms.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    @Test
    public void testSimple1() {
        System.out.println(doCombinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> doCombinationSum(int[] a, int target) {
        List<List<Integer>> result = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<>();
        int sum = 0;
        return doCombinationSum(a, target, output, sum, 0, result);
    }

    public List<List<Integer>> doCombinationSum(int[] a, int target, ArrayList<Integer> output, int sum, int index, List<List<Integer>> result) {
        if (sum == target) {
            result.add((List<Integer>) output.clone());
        } else if (sum < target) {
            for (int i = index; i < a.length; i++) {
                ArrayList<Integer> newOutput = (ArrayList<Integer>) output.clone();
                int newSum = sum + a[i];
                newOutput.add(a[i]);
                doCombinationSum(a, target, newOutput, newSum, i, result);
            }
        }
        return result;
    }
}
