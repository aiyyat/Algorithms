package com.aiyyatti.algorithms.hackerrank;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    @Test
    public void simpleTest() {
        String str = "({()})";
        System.out.println(doJavaStack(str));
    }

    public static boolean doJavaStack(String str) {
        Stack<Character> stack = new Stack<>();
        char[] a = str.toCharArray();
        int N = str.length();
        for (int i = 0; i < N; i++) {
            switch (a[i]) {
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    else break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    else break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    else break;
                default:
                    stack.push(a[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(doJavaStack(input));
        }
    }
}
