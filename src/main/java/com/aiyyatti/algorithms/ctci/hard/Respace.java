package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;
import java.util.HashSet;

public class Respace {
    ///////////////
    // TEST CASE //
    ///////////////
    @Test
    public void simpleTest() {
        HashSet<String> dict = new HashSet<>();
        dict.add("we");
        dict.add("a");
        dict.add("number");
        dict.add("guy");
        dict.add("named");
        dict.add("had");
        dict.add("awesome");
        dict.add("at");
        dict.add("cat");
        dict.add("pet");
        dict.add("dilemma");
        String str = "weeeeaguynamedawesomehadacatnameddilemmahasapetnamedguy";
        System.out.println(doRespace(str, dict, 0, new Match[str.length()]));
    }

    class Match {
        int bestMisMatchCount = Integer.MAX_VALUE;
        String bestMatchString = "";

        public Match() {
        }

        public Match(int bestMisMatchCount, String bestMatchString) {
            this.bestMisMatchCount = bestMisMatchCount;
            this.bestMatchString = bestMatchString;
        }

        @Override
        public String toString() {
            return bestMatchString;
        }
    }

    public Match doRespace(String str, HashSet<String> dict, int index, Match[] memo) {
        int N = str.length();
        if (index == N) return new Match(0, "");
        if (memo[index] != null) return memo[index];
        String prefix = "";
        Match bestMatch = new Match(Integer.MAX_VALUE, "");
        for (int i = index; i < N; i++) {
            char charAt = str.charAt(i);
            prefix += charAt;
            int invalid = prefix.length();
            String newString = charAt + " ";
            if (dict.contains(prefix)) {
                invalid = 0;
                newString = prefix + " ";
            }
            Match rest = doRespace(str, dict, i + 1, memo);
            if (bestMatch.bestMisMatchCount > rest.bestMisMatchCount + invalid) {
                bestMatch = new Match(rest.bestMisMatchCount + invalid, newString + rest.bestMatchString);
                memo[index] = bestMatch;
            }
        }
        return bestMatch;
    }
}

