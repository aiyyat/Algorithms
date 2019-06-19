package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Source: Cracking The Coding Interview.
 * Time:
 * Todo:
 * Redo: Yes
 * Notes: regular all combination splits of a string. start with white board.
 */
public class Respace {
    private static final Logger logger = getLogger(Respace.class);

    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void test() {
        assertThat(doRespace("awesome").word).isEqualTo(" a w e s o m e");
    }

    @Test
    public void test3() {
        dictionary.add("we");
        assertThat(doRespace("awesome").word).isEqualTo(" a we s o m e");
    }

    @Test
    public void test4() {
        dictionary.add("we");
        dictionary.add("some");
        assertThat(doRespace("awesome").word).isEqualTo(" a we some");
    }

    @Test
    public void test2() {
        dictionary.add("awesome");
        assertThat(doRespace("awesome").word).isEqualTo(" awesome");
    }

    //////////////
    // SOLUTION //
    //////////////
    Set<String> dictionary = new HashSet<>();

    public BestMatch doRespace(String str) {
        int N = str.length();
        if (dictionary.contains(str)) return new BestMatch(" " + str, 0);
        else if (str.length() == 0) return new BestMatch();
        else if (str.length() == 1) return new BestMatch(" " + str, 1);
        else {
            BestMatch localBestMatch = new BestMatch("", Integer.MAX_VALUE);
            for (int i = 1; i < N; i++) {
                String leftStr = str.substring(0, i);
                BestMatch left = doRespace(leftStr);
                String rightStr = str.substring(i, N);
                BestMatch right = doRespace(rightStr);
                BestMatch merged = merge(left, right);
                if (localBestMatch.compareTo(merged) > 0) {
                    localBestMatch = merged;
                }
            }
            return localBestMatch;
        }
    }

    public BestMatch merge(BestMatch bm1, BestMatch bm2) {
        return new BestMatch(bm1.word + bm2.word, bm1.mismatch + bm2.mismatch);
    }

    class BestMatch implements Comparable<BestMatch> {
        String word = "";
        int mismatch = 0;

        public BestMatch() {
        }

        public BestMatch(String word, int mismatch) {
            this.word = word;
            this.mismatch = mismatch;
        }

        @Override
        public int compareTo(BestMatch o) {
            return this.mismatch - o.mismatch;
        }
    }
}
