package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.Arrays;

public class Shuffle {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void shuffleTest() {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) deck[i] = i + 1;
        doShuffle(deck);
        System.out.println(Arrays.toString(deck));
    }

    public void doShuffle(int[] deck) {
        int N = deck.length;
        for (int i = 0; i < N; i++) {
            int random = (i + (int) ((52 - i) * Math.random()));
            int temp = deck[random];
            deck[random] = deck[i];
            deck[i] = temp;
        }
    }
}
