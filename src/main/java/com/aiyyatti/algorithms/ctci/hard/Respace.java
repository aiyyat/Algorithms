package com.aiyyatti.algorithms.ctci.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Respace {
    @Test
    public void simpleTest() {
        String input = "youareawesome";
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("you");
        dictionary.add("are");
        dictionary.add("awesome");
        dictionary.add("some");
        dictionary.add("me");
        System.out.println(doRespace(input, dictionary));
    }

    public String doRespace(String input, HashSet<String> dictionary) {
        return doRespace(input, dictionary, 0).bestPartition;
    }

    public ParseResult doRespace(String input, HashSet<String> dictionary, int index) {
        if (index >= input.length()) return new ParseResult(0, "");
        String partition = "";
        Integer bestInvalid = Integer.MAX_VALUE;
        String bestPartition = "";
        for (; index < input.length(); index++) {
            partition += input.charAt(index);
            System.out.println(partition);
            int invalidIndex = dictionary.contains(partition) ? 0 : partition.length();
            if (invalidIndex < bestInvalid) {
                ParseResult parseResult = doRespace(input, dictionary, index + 1);
                if (invalidIndex + parseResult.bestInvalid < bestInvalid) {
                    bestInvalid = invalidIndex + parseResult.bestInvalid;
                    bestPartition = partition + " " + parseResult.bestPartition;
                    if (bestInvalid == 0) break;
                }
            }
        }
        return new ParseResult(bestInvalid, bestPartition);
    }

    class ParseResult {
        int bestInvalid = Integer.MAX_VALUE;
        String bestPartition = "";

        public ParseResult(int bestInvalid, String bestPartition) {
            this.bestInvalid = bestInvalid;
            this.bestPartition = bestPartition;
        }
    }
}
