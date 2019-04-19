package com.aiyyatti.algorithms.ctci.stacksandqueues;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueViaStacks {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test(expected = EmptyStackException.class)
    public void simpleTest() {
        QueueViaStacksDS queue = new QueueViaStacksDS();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        TestCase.assertEquals(1, queue.remove());
        TestCase.assertEquals(2, queue.remove());
        TestCase.assertEquals(3, queue.remove());
        TestCase.assertEquals(4, queue.remove());
        TestCase.assertEquals(5, queue.remove());
        TestCase.assertEquals(6, queue.remove());
        TestCase.assertEquals(7, queue.remove());
        TestCase.assertEquals(8, queue.remove());
        queue.remove();
    }
}

class QueueViaStacksDS {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(int i) {
        stack1.push(i);
    }

    public int remove() {
        if (stack2.isEmpty()) transfer();
        return stack2.pop();
    }

    public void transfer() {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
    }
}