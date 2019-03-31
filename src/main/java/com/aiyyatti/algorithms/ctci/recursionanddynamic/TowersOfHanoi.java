package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO: learn from: https://www.youtube.com/watch?v=3YH0SZYAzOQ
 */
public class TowersOfHanoi {
    @Test
    public void simpleTest() {
        doTowerOfHanoi(3);
    }

    public void doTowerOfHanoi(int discs) {
        Stack<Integer> source = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        for (int i = discs; i > 0; i--) source.push(i);
        System.out.printf("%s %s %s\n", source, destination, buffer);
        doTowerOfHanoi(discs, source, destination, buffer, source, destination, buffer);
        System.out.println(source);
    }

    public void doTowerOfHanoi(int discs,
                               Stack<Integer> justToPrintSource, Stack<Integer> justToPrintDestination, Stack<Integer> justToPrintBuffer,
                               Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        if (discs <= 0) return;
        doTowerOfHanoi(discs - 1, justToPrintSource, justToPrintDestination, justToPrintBuffer, a, c, b);
        move(a, b);
        System.out.printf("%s %s %s\n", justToPrintSource, justToPrintDestination, justToPrintBuffer);
        doTowerOfHanoi(discs - 1, justToPrintSource, justToPrintDestination, justToPrintBuffer, c, b, a);
    }

    public void move(Stack<Integer> source, Stack<Integer> destination) {
        if (!source.isEmpty()) destination.push(source.pop());
    }

    public void swap(Stack<Integer> source, Stack<Integer> destination) {
        if (!source.isEmpty())
            destination.push(source.pop());
    }
}
