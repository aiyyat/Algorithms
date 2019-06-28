package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time: 20.38
 * Todo: See alternate approaches.
 * Redo: Yes
 * Notes:
 */
public class KthMultiple {
    private static final Logger logger = getLogger(KthMultiple.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        assertThat(findKthMultiple(14)).isEqualTo(81);
        assertThat(findKthMultiple(11)).isEqualTo(49);
        assertThat(findKthMultiple(4)).isEqualTo(9);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int findKthMultiple(int K) {
        Queue<Integer> p3 = new PriorityQueue<>();
        Queue<Integer> p5 = new PriorityQueue<>();
        Queue<Integer> p7 = new PriorityQueue<>();
        p3.add(3);
        p5.add(5);
        p7.add(7);
        int output = -1;
        while (K-- != 0) {
            int three = p3.peek();
            int five = p5.peek();
            int seven = p7.peek();
            if (three < five && three < seven) {
                p3.poll();
                p3.add(three * 3);
                p5.add(three * 5);
                p7.add(three * 7);
                output = three;
            } else if (five < seven) {
                p5.poll();
                p5.add(five * 5);
                p7.add(seven * 5);
                output = five;
            } else {
                p7.poll();
                p7.add(seven * 7);
                output = seven;
            }
        }
        return output;
    }
}
