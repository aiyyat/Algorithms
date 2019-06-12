package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class Parens {
    @Test
    public void simpleTest() {
        String expected = "[()()()()(), (())()()(), ()(())()(), ()()(())(), ()()()(()), (()())()(), ((()))()(), (())(())(), (())()(()), ()(()())(), ()((()))(), ()(())(()), ()()(()()), ()()((())), (()()())(), ((())())(), (()(()))(), (()())(()), ((()()))(), (((())))(), ((()))(()), (())(()()), (())((())), ()(()()()), ()((())()), ()(()(())), ()((()())), ()(((()))), (()()()()), ((())()()), (()(())()), (()()(())), ((()())()), (((()))()), ((())(())), (()(()())), (()((()))), ((()()())), (((())())), ((()(()))), (((()()))), ((((()))))]";
        assertEquals(expected, doParens(5));
    }

    @Test
    public void simple2Test() {
        String expected = "[()()(), (())(), ()(()), (()()), ((()))]";
        assertEquals(expected, doParens(3));
    }

    public void compare(String expected, Set<String> actual) {
        System.out.println(actual);
    }

    public Set<String> doParens(int N) {
        HashSet<String> input = new HashSet<>();
        input.add("()");
        return doParens(input, 1, N);
    }

    public Set<String> doParens(Set<String> input, int at, int N) {
        if (at == N) return input;
        Set<String> output = new LinkedHashSet<>();
        for (Iterator<String> itr = input.iterator(); itr.hasNext(); ) {
            String paren = itr.next();
            for (int i = 0; i < paren.length(); i++) {
                output.add(insertAtPosition(paren, i));
            }
        }
        return doParens(output, at + 1, N);
    }

    public String insertAtPosition(String str, int i) {
        return str.substring(0, i) + "()" + str.substring(i);
    }
}
