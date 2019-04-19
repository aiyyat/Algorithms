package com.aiyyatti.algorithms.gfg.string;

import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 */
public class ReverseWordsInAGivenString {
    ////////////////
    // TEST CASES //
    ////////////////
    @Test
    public void testSimple1() {
        System.out.println(doReverseWordsInAGivenString("i.like.this.program.very.much"));
    }

    public static void main(String[] args) {
        new ReverseWordsInAGivenString().doReverseWordsInAGivenString(System.in);
    }

    public void doReverseWordsInAGivenString(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.println(doReverseWordsInAGivenString(scanner.next()));
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception e1) {

            }
        }
    }

    public String doReverseWordsInAGivenString(String str) {
        int nextIndex = str.indexOf(".");
        if (nextIndex == -1) return str;
        return doReverseWordsInAGivenString(str.substring(nextIndex + 1)) + "." + str.substring(0, nextIndex);
    }
}
