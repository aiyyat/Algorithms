package com.aiyyatti.algorithms.ctci.stacksandqueues;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackMin {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void ctciTest() {
        StackMinDS sm = new StackMinDS();
        sm.push(5);
        sm.push(6);
        sm.push(3);
        sm.push(7);
        TestCase.assertEquals(3, sm.min());
        TestCase.assertEquals(7, sm.pop());
        TestCase.assertEquals(3, sm.min());
        TestCase.assertEquals(3, sm.pop());
        TestCase.assertEquals(5, sm.min());
        TestCase.assertEquals(6, sm.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void corner1Test() {
        StackMinDS sm = new StackMinDS();
        sm.pop();
    }

    class StackMinDS {
        private Stack<StackMinElement> stack = new Stack<>();

        public void push(int i) {
            int min = i;
            int prev = i;
            if (!stack.isEmpty() && (prev = stack.peek().min) < i) min = prev;
            stack.push(new StackMinElement(i, min));
        }

        public int peek() {
            return stack.peek().element;
        }

        public int pop() {
            return stack.pop().element;
        }

        public int min() {
            return stack.peek().min;
        }

        class StackMinElement {
            int element;
            int min;

            public StackMinElement(int element, int min) {
                this.element = element;
                this.min = min;
            }
        }
    }


}
