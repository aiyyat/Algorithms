package com.aiyyatti.algorithms.ctci.recursionanddynamic;

import junit.framework.TestCase;
import org.junit.Test;

//public class BooleanExpression {
//    @Test
//    public void ctciTest() {
//        TestCase.assertEquals(2, evaluate("1^0|0|1", false));
//    }
//
//    public Match evaluate(String str, boolean check) {
//        return evaluate(str, check, new Match(false, 0), 0);
//    }
//
//    public Match evaluate(String str, boolean check, Match match, int N) {
//        int count = match.count;
//        if (str.length() == N) {
//            return match.result == true ? new Match(count + 1, true) : match;
//        }
//        if (str.length() == 1) return new Match(0,str.charAt(0) == '1');
//        else {
//            int count =0;
//            for(int i=1;i<N;i+=2) {
//                if(evaluate(
//                        evaluate(str.substring(0,i),check,match,N).result
//                        ,str.charAt(i),
//                        evaluate(str.substring(i+1),check,match,N).result)==check) {
//                    count++;
//                }
//            }
//            return new Match(
//        }
//
//    }
//
//    public boolean evaluate(boolean left, char op, boolean right) {
//        switch (op) {
//            case '|':
//                return left | right;
//            case '&':
//                return left & right;
//            case '^':
//                return left ^ right;
//        }
//    }
//
//    class Match {
//        int count;
//        boolean result;
//
//        public Match(int count, boolean result) {
//            this.count = count;
//            this.result = result;
//        }
//    }
//}
