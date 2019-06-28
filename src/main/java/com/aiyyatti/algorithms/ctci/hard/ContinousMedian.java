package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.PriorityQueue;

import static junit.framework.TestCase.assertTrue;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes:
 */
public class ContinousMedian {
    private static final Logger logger = getLogger(ContinousMedian.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        int[] input = new int[]{2, 5, 7, 1, 9, 2, 4, 6, 3, 0, 9, 6, 2, 5, 7, 2, 1, 6, 7, 4, 2, 2, 7, 8, 8, 5, 3, 2, 4, 6, 7, 8, 9, 4, 2, 0, 1, 8, 9, 4, 2, 1, 2, 3, 4, 5, 2};
        findContinousMedian(input);
    }

    //////////////
    // SOLUTION //
    //////////////
    public void findContinousMedian(int[] a) {
        int N = a.length;
        PriorityQueue<Integer> p1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> p2 = new PriorityQueue<>((o1, o2) -> o1 - o2);
        Integer count = 0, extra = null;
        double mean = 0;
        for (int i = 0; i < N; i++) {
            if (count % 2 == 0) {
                PriorityQueue<Integer> pq = null;
                // when even count either both are empty or both have values.
                if (p1.isEmpty()) {
                    mean = extra = a[i];
                } else {
                    if (a[i] < mean) pq = p1;
                    else pq = p2;
                    pq.add(a[i]);
                    mean = extra = pq.poll();
                }
            } else {
                insertIntoAppropriate(p1, p2, mean, extra);
                insertIntoAppropriate(p1, p2, mean, a[i]);
                balance(p1, p2);
                mean = (p1.peek() + p2.peek()) / 2.0;
            }
            count++;
            logger.debug("{}({}){}\n", p1, mean, p2);
            if (!p1.isEmpty()) {
                assertTrue(p1.peek() <= mean);
                assertTrue(p2.peek() >= mean);
            }
        }
    }

    public void insertIntoAppropriate(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2, Double mean, Integer toInsert) {
        if (toInsert <= mean) p1.add(toInsert);
        else p2.add(toInsert);
    }

    public void balance(PriorityQueue<Integer> p1, PriorityQueue<Integer> p2) {
        while (p1.size() != p2.size()) {
            if (p1.size() > p2.size()) p2.add(p1.poll());
            else p1.add(p2.poll());
        }
    }
}
