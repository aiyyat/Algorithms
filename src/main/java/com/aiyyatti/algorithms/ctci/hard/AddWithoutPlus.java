package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Source: Cracking The Coding Interview.
 * Time: 10.41
 * Todo:
 * Redo: No
 */
public class AddWithoutPlus {
    private static final Logger logger = LoggerFactory.getLogger(AddWithoutPlus.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest1() {
        assertThat(doAddWithoutPlus(3, 5)).isEqualTo(8);
    }

    @Test
    public void simpleTest2() {
        assertThat(doAddWithoutPlus(3, 0)).isEqualTo(3);
    }

    @Test
    public void simpleTest3() {
        assertThat(doAddWithoutPlus(0, 5)).isEqualTo(5);
    }

    @Test
    public void simpleTest4() {
        assertThat(doAddWithoutPlus(-3, -5)).isEqualTo(-8);
    }

    //////////////
    // SOLUTION //
    //////////////
    public int doAddWithoutPlus(int a, int b) {
        int s = a;
        int c = b;
        while (c != 0) {
            a = s;
            b = c;
            s = a ^ b;
            c = (a & b) << 1;
        }
        return s;
    }
}