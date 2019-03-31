package com.aiyyatti.algorithms.gfg.lexicographicpattern;

import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0/?ref=self
 */
public class PermutationsOfAGivenString {
    @Test
    public void testSimple() {
        new PermutationsOfAGivenString().doPermutationsOfAGivenString("ABC", "");
    }

    @Test
    public void testSimple1() {
        new PermutationsOfAGivenString().doPermutationsOfAGivenString("SABHD");
    }

    public static void main(String[] args) {
        new PermutationsOfAGivenString().doPermutationsOfAGivenString(System.in);
    }

    public void doPermutationsOfAGivenString(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            while (T-- > 0) {
                doPermutationsOfAGivenString(scanner.next());
                System.out.println();
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void doPermutationsOfAGivenString(String str) {
        char[] out = str.toCharArray();
        Arrays.sort(out);
        doPermutationsOfAGivenString(new String(out), "");
    }

    public void doPermutationsOfAGivenString(String str, String leftOver) {
        if (str.equals("")) {
            System.out.print(leftOver + " ");
        }
        for (int i = 0; i < str.length(); i++) {
            String part1 = str.substring(0, i);
            char part2 = str.charAt(i);
            String part3 = str.substring(i + 1);
            doPermutationsOfAGivenString(part1 + part3, leftOver + part2);
        }
    }
}
