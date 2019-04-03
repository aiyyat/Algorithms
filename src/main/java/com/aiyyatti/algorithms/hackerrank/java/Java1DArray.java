package com.aiyyatti.algorithms.hackerrank.java;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Scanner;

public class Java1DArray {
    @Test
    public void simpleTest() {
        TestCase.assertTrue(canWin(3, new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    public void simple2Test() {
        TestCase.assertFalse(canWin(3, new int[]{0, 0, 1, 1, 1, 0}));
    }

    @Test
    public void simple3Test() {
        TestCase.assertTrue(canWin(1, new int[]{0}));
    }

    @Test
    public void simple4Test() {
        TestCase.assertFalse(canWin(6, new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1}));
    }

    @Test
    public void simple5Test() {
        TestCase.assertFalse(canWin(3, new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1}));
    }

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }

    public static boolean canWin(int leap, int[] game, int index) {
        int N = game.length;
        if (game[index] == 0) {
            int leaped = index + leap;
            if (leaped > N - 1 || (leaped == N - 1 && game[leaped] == 0)) return true;
            else if (canWin(leap, game, index + 1)) return true;
            else if (canWin(leap, game, index + leap)) return true;
            else if (index > 0) {
                game[index] = 1;
                if (canWin(leap, game, index - 1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
