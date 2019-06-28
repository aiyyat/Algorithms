package com.aiyyatti.algorithms.ctci.moderate;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

public class Calculator {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void calculate() {
        assertEquals(23.5, doCalculate("2*3+5/6*3+15"));
    }

    @Test
    public void calculate2() {
        assertEquals(-27.0, doCalculate("2-6-7*8/2+5"));
    }

    //////////////
    // SOLUTION //
    //////////////

    /**
     * TODO: optimize code.
     *
     * @param str
     * @return
     */
    public double doCalculate(String str) {
        char[] a = str.toCharArray();
        Stack<BinaryOperation> ops = new Stack<>();
        Stack<Double> ns = new Stack<>();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            if (isDigit(a[i])) {
                String number = "" + a[i];
                while (i + 1 < N && isDigit(a[i + 1])) number += a[++i];
                ns.push(Double.valueOf(number));
            } else {
                BinaryOperation thisOp = OperationFactory.getOpsInstance(a[i]);
                if (ops.isEmpty()) {
                    ops.push(OperationFactory.getOpsInstance(a[i]));
                } else if (!ops.isEmpty()) {
                    BinaryOperation prevOp = ops.peek();
                    if (prevOp.comparePriority(thisOp) < 0) {
                        String number = "" + a[++i];
                        while (isDigit(a[i + 1])) number += a[++i];
                        ns.push(thisOp.perform(ns.pop(), Double.valueOf(number)));
                    } else {
                        double digit1 = ns.pop();
                        double digit2 = ns.pop();
                        ns.push(ops.pop().perform(digit2, digit1));
                        ops.push(thisOp);
                    }
                }
            }
        }
        // left overs.
        while (!ops.isEmpty()) {
            double digit1 = ns.pop();
            double digit2 = ns.pop();
            ns.push(ops.pop().perform(digit2, digit1));
        }
        return ns.pop();
    }

    public boolean isDigit(char a) {
        return Character.isDigit(a);
    }
}

class OperationFactory {
    public static BinaryOperation getOpsInstance(char ch) {
        switch (ch) {
            case '-':
                return new Subtraction();
            case '+':
                return new Addition();
            case '*':
                return new Multiplication();
            case '/':
                return new Division();
            default:
                throw new UnsupportedOperationException("What does it mean to do a" + ch + "?");
        }
    }
}

interface PriorityCheckable {
    public abstract int priority();
}

interface MediumPriority extends PriorityCheckable {
    default public int priority() {
        return 5;
    }
}

interface HighPriority extends PriorityCheckable {
    default public int priority() {
        return 8;
    }
}

abstract class BinaryOperation implements PriorityCheckable {

    public int comparePriority(BinaryOperation that) {
        return this.priority() - that.priority();
    }

    public double perform(double a, double b) {
        throw new UnsupportedOperationException("Not supported");
    }
}


class Multiplication extends BinaryOperation implements HighPriority {
    @Override
    public double perform(double a, double b) {
        return a * b;
    }
}

class Division extends BinaryOperation implements HighPriority {
    @Override
    public double perform(double a, double b) {
        return a / b;
    }
}

class Addition extends BinaryOperation implements MediumPriority {
    @Override
    public double perform(double a, double b) {
        return a + b;
    }
}

class Subtraction extends BinaryOperation implements MediumPriority {
    @Override
    public double perform(double a, double b) {
        return a - b;
    }
}