package com.aiyyatti.algorithms.ctci.stacksandqueues;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO: read the second approach in CTCI.
 */
public class ThreeInOne {
    ////////////////
    // TEST CASES //
    ////////////////
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void simpleTest() {
        expectedEx.expect(ThreeInOneStackException.class);
        expectedEx.expectMessage("Index of Stack: 1 outside [3 & 5]");
        ThreeInOneStack stack = new ThreeInOneStack(9);
        stack.push(1, 1);
        stack.push(1, 2);
        stack.push(1, 3);
        stack.push(2, 4);
        stack.push(2, 5);
        stack.push(2, 6);
        stack.push(3, 7);
        stack.push(3, 8);
        stack.push(3, 9);
        assertEquals(6, stack.poll(2));
        assertEquals(5, stack.poll(2));
        assertEquals(4, stack.poll(2));
        stack.push(2, 5);
        stack.push(2, 6);
        assertEquals(6, stack.poll(2));
        assertEquals(5, stack.poll(2));
        stack.poll(2);
    }

    class ThreeInOneStack {
        int N = 0;
        int[] stackIndex = new int[4];
        int[] a;

        @Override
        public String toString() {
            return "ThreeInOneStack{" +
                    "a=" + Arrays.toString(a) +
                    '}';
        }

        public ThreeInOneStack(int N) {
            this.N = N;
            a = new int[N];
            stackIndex[1] = 0;
            stackIndex[2] = (N / 3);
            stackIndex[3] = (2 * N / 3);
        }

        public void push(int stackNumber, int value) {
            a[indexOf(stackNumber)] = value;
            stackIndex[stackNumber] += 1;
        }

        public int peek(int stackNumber) {
            return a[indexOf(stackNumber)];
        }

        public int poll(int stackNumber) {
            int value = a[indexOf(stackNumber)];
            stackIndex[stackNumber] -= 1;
            return value;
        }

        public int indexOf(int stackNumber) {
            int to = ((stackNumber + 1) * N / 3) - 1;
            int from = stackNumber * N / 3;
            if ((stackIndex[stackNumber] < from) || (stackIndex[stackNumber] > to))
                throw new ThreeInOneStackException(String.format("Index of Stack: %s outside [%s & %s]", stackNumber, from, to));
            return stackIndex[stackNumber];
        }
    }

    class ThreeInOneStackException extends ArrayIndexOutOfBoundsException {
        public ThreeInOneStackException(String s) {
            super(s);
        }
    }
}
