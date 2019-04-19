package com.aiyyatti.algorithms.ctci.stacksandqueues;

import org.junit.Test;

import java.util.Stack;

public class SortStack {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void ctciTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(10);
        stack.push(3);
        stack.push(1);
        stack.push(0);
        stack.push(5);
        stack.push(8);
        stack.push(12);
        System.out.println(sort(stack));
    }

    public Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > temp) stack.push(tmpStack.pop());
            tmpStack.push(temp);
        }
        return tmpStack;
    }
}
