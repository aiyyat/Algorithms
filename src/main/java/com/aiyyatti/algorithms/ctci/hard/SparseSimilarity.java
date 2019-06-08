package com.aiyyatti.algorithms.ctci.hard;

import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class SparseSimilarity {
    @Test
    public void ctciTest() {
        Map<Integer, int[]> input = new HashMap<>();
        input.put(13, new int[]{14, 15, 100, 9, 3});
        input.put(16, new int[]{32, 1, 9, 3, 5});
        input.put(19, new int[]{15, 29, 2, 6, 8, 7});
        input.put(24, new int[]{7, 10});
        String expected = "16 13 => 0.25\n" +
                "19 24 => 0.14285714285714285\n" +
                "19 13 => 0.1\n";
        assertThat(doSparseSimilarity(input), is(equalTo(expected)));
    }

    public String doSparseSimilarity(Map<Integer, int[]> a) {
        StringBuffer output = new StringBuffer("");
        int N = a.size();
        int[] keys = new int[N];
        int[][] values = new int[N][];
        MutableInt index = new MutableInt(0);
        a.forEach((key, value) -> {
            keys[index.intValue()] = key;
            values[index.intValue()] = value;
            index.increment();
        });
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double sparse = doSparse(values[i], values[j]);
                if (sparse > 0) output.append(String.format("%s %s => %s\n", keys[i], keys[j], sparse));
            }
        }
        return output.toString();
    }

    public double doSparse(int[] a, int[] b) {
        Set<Integer> t = new HashSet<>();
        for (int i = 0; i < a.length; i++) t.add(a[i]);
        int union = t.size(), intersection = 0;
        for (int i = 0; i < b.length; i++) {
            if (t.contains(b[i])) intersection++;
            else union++;
        }
        return union == 0 ? 0 : (1.0 * intersection / union);
    }
}
