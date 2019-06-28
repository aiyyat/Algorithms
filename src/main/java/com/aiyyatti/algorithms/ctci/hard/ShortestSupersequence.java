package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: No
 * Notes:
 */
public class ShortestSupersequence {
    private static final Logger logger = getLogger(ShortestSupersequence.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void testSimple() {
        System.out.println(findShortestSuperSequence(new int[]{1, 2, 2, 2, 6, 2, 2, 2, 5, 1, 2, 5, 6, 5, 1, 2, 5}, new int[]{1, 2, 6}));
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findShortestSuperSequence(int[] a, int[] seq) {
        Map<Integer, Queue<Element>> qs = new HashMap<>();
        for (int i = 0; i < seq.length; i++) qs.put(seq[i], new LinkedList<Element>());
        int N = a.length;
        for (int i = 0; i < N; i++) {
            Queue<Element> q = qs.get(a[i]);
            if (q != null) q.add(new Element(i, q));
        }
        PriorityQueue<Element> pq = new PriorityQueue<Element>((o1, o2) -> o1.data - o2.data);
        Element max = new Element(Integer.MIN_VALUE, null);
        for (int i = 0; i < seq.length; i++) {
            Element top = qs.get(seq[i]).poll();
            pq.add(top);
            max = max.data < top.data ? top : max;
        }
        int minDist = Integer.MAX_VALUE;
        Element min = pq.poll();
        while (true) {
            minDist = Math.min(minDist, max.data - min.data);
            if (min.queue.isEmpty()) return minDist + 1;
            Element replcement = min.queue.poll();
            if (replcement.data > max.data) max = replcement;
            pq.add(replcement);
            min = pq.poll();
        }
    }

    class Element {
        int data;
        Queue<Element> queue;

        public Element(int data, Queue<Element> queue) {
            this.data = data;
            this.queue = queue;
        }
    }
}