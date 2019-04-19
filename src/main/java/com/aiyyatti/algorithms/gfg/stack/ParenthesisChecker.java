package com.aiyyatti.algorithms.gfg.stack;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class ParenthesisChecker {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple1() {
        TestCase.assertFalse(checkParanthesis("(()"));
    }

    @Test
    public void testSimple2() {
        TestCase.assertTrue(checkParanthesis("{([])}"));
    }

    @Test
    public void testSimple3() {
        TestCase.assertTrue(checkParanthesis("()"));
    }

    @Test
    public void testSimple4() {
        TestCase.assertFalse(checkParanthesis(" ([]"));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        new ParenthesisChecker().checkParanthesis(System.in);
    }

    public void checkParanthesis(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                if (checkParanthesis(scanner.next())) {
                    System.out.println("balanced");
                } else {
                    System.out.println("not balanced");
                }
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception e2) {
            }
        }
    }

    public boolean checkParanthesis(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (!(last == '{' && ch == '}') && (last == '(' && ch == ')') && (last == '[' && ch == ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
