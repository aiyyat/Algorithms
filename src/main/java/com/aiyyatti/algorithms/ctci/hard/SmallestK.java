package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class SmallestK {
    private static final Logger logger = getLogger(SmallestK.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        int[] a = new int[]{3, 4, 6, 9, 2, 1, 0, 5, 8, 7, 11, 15, 12, 13, 14, 10};
        for (int i = 0; i < 15; i++) {
            assertThat(smallestKthPriorityQueue(a, i)).isEqualTo(i);
            assertThat(smallestKthSelectionRank(a, i)).isEqualTo(i);
        }
    }

    @Test
    public void simpleTest2() {
        int[] a = new int[]{3, 4, 6, 9, 2, 1, 0, 5, 8, 7, 11, 15, 12, 13, 14, 10};
        assertThat(smallestKthSelectionRank(a, 0)).isEqualTo(0);
    }
    //////////////
    // SOLUTION //
    //////////////

    /**
     * Time Complexity: O(n*log(k))
     *
     * @param a
     * @param K
     * @return
     */
    public int smallestKthSelectionRank(int[] a, int K) {
        return smallestKthSelectionRank(a, K, 0, a.length - 1);
    }

    public int smallestKthSelectionRank(int[] a, int K, int start, int end) {
        if (start > end) return -1;
        int pilot = start, begin = start + 1, last = end;
        while (true) {
            while (begin <= end && a[begin] < a[pilot]) begin++;
            while (last >= start && a[last] > a[pilot]) last--;
            if (begin >= last) break;
            swap(a, begin, last);
        }
        swap(a, last, pilot);
        pilot = last;
        if (pilot == K) return a[pilot];
        else if (pilot < K) return smallestKthSelectionRank(a, K, pilot + 1, end);
        else return smallestKthSelectionRank(a, K, start, pilot - 1);
    }

    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public int smallestKthPriorityQueue(int[] a, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if (queue.size() <= K) queue.add(a[i]);
            else if (queue.peek() > a[i]) {
                queue.poll();
                queue.add(a[i]);
            }
        }
        return queue.poll();
    }
}
