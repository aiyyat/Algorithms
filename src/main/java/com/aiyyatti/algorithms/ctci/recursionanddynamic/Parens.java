package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Parens {
    @Test
    public void simpleTest() {
        String expected = "[((((())))), (((()()))), (((())())), (((()))()), (((())))(), ((()(()))), ((()()())), ((()())()), ((()()))(), ((())(())), ((())()()), ((())())(), ((()))(()), ((()))()(), (()((()))), (()(()())), (()(())()), (()(()))(), (()()(())), (()()()()), (()()())(), (()())(()), (()())()(), (())((())), (())(()()), (())(())(), (())()(()), (())()()(), ()(((()))), ()((()())), ()((())()), ()((()))(), ()(()(())), ()(()()()), ()(()())(), ()(())(()), ()(())()(), ()()((())), ()()(()()), ()()(())(), ()()()(()), ()()()()()]";
        TestCase.assertEquals(expected, doParens(5).toString());
    }
    @Test
    public void simple2Test() {
        String expected = "[((((())))), (((()()))), (((())())), (((()))()), (((())))(), ((()(()))), ((()()())), ((()())()), ((()()))(), ((())(())), ((())()()), ((())())(), ((()))(()), ((()))()(), (()((()))), (()(()())), (()(())()), (()(()))(), (()()(())), (()()()()), (()()())(), (()())(()), (()())()(), (())((())), (())(()()), (())(())(), (())()(()), (())()()(), ()(((()))), ()((()())), ()((())()), ()((()))(), ()(()(())), ()(()()()), ()(()())(), ()(())(()), ()(())()(), ()()((())), ()()(()()), ()()(())(), ()()()(()), ()()()()()]";
        TestCase.assertEquals(expected, doParens(3).toString());
    }

    public List<String> doParens(int N) {
        return doParens(0, 0, "", N);
    }

    public List<String> doParens(int open, int close, String prefix, int N) {
        List<String> output = new ArrayList<>();
        if (prefix.length() == N * 2) {
            output.add(prefix);
            return output;
        }
        if (open < N) output.addAll(doParens(open + 1, close, prefix + "(", N));
        if (close < open) output.addAll(doParens(open, close + 1, prefix + ")", N));
        return output;
    }
}
