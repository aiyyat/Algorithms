package com.aiyyatti.algorithms.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * https://www.programcreek.com/2014/01/leetcode-minimum-window-subsequence-java/
 */
public class MinimumSubstringWithoutRepeatingCharacters {
    @Test
    public void testSimple() {
        String s1 = "anananaadanannadanandannandanandand";
        String s2 = "anand";
        TestCase.assertEquals("16->20 anand", doMinimumSubstringWithoutRepeatingCharacaters(s1, s2).toString());
    }

    @Test
    public void testSimple2() {
        String s1 = "abacka";
        String s2 = "back";
        TestCase.assertEquals("1->4 back", doMinimumSubstringWithoutRepeatingCharacaters(s1, s2).toString());
    }

    @Test
    public void testSimple3() {
        String s1 = "abacka";
        String s2 = "dw";
        TestCase.assertNull(doMinimumSubstringWithoutRepeatingCharacaters(s1, s2));
    }

    @Test
    public void testSimple4() {
        String s1 = "abaaacka";
        String s2 = "back";
        TestCase.assertEquals("1->6 baaack", doMinimumSubstringWithoutRepeatingCharacaters(s1, s2).toString());
    }

    private Answer doMinimumSubstringWithoutRepeatingCharacaters(String s1str, String s2str) {
        char[] s1 = s1str.toCharArray();
        char[] s2 = s2str.toCharArray();
        return doMinimumSubstringWithoutRepeatingCharacaters(s1, s2);
    }

    private Answer doMinimumSubstringWithoutRepeatingCharacaters(char[] s1, char[] s2) {
        int s1p = 0, s2p = 0;
        Answer min = null;
        while (s1p < s1.length - 1) {
            if (s1[s1p] == s2[s2p]) {
                if (s2p == s2.length - 1) {
                    int lastIndexAts1 = s1p;
                    inner:
                    while (true) {
                        if (s1[s1p] == s2[s2p]) {
                            if (s2p <= 0) {
                                min = min(min, new Answer(s1, s1p, lastIndexAts1));
                                if (min.diff() + 1 == s2.length) return min; // early exit
                                s1p = lastIndexAts1;
                                s2p = 0;
                                break inner;
                            }
                            s2p--;
                        }
                        s1p--;
                    }
                }
                s2p++;
            }
            s1p++;
        }
        return min;
    }

    private Answer min(Answer a1, Answer a2) {
        if (a1 == null) return a2;
        if (a2 == null) return a1;
        return (a1.compareTo(a2) > 0) ? a2 : a1;
    }

    class Answer implements Comparable<Answer> {
        int from = -1, to = -1;
        char[] ch;

        public Answer(char[] ch, int from, int to) {
            this.from = from;
            this.ch = ch;
            this.to = to;
        }

        public int diff() {
            if (from == -1 || to == -1) throw new IllegalStateException("Not set properly");
            return to - from;
        }

        @Override
        public int compareTo(Answer answer) {
            return this.diff() - answer.diff();
        }

        @Override
        public String toString() {
            String out = "";
            for (int i = from; i <= to; i++) {
                out += ch[i];
            }
            return from + "->" + to + " " + out;
        }
    }
}
