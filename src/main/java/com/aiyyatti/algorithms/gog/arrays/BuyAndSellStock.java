package com.aiyyatti.algorithms.gog.arrays;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BuyAndSellStock {
    @Test
    public void testSimple() {
        String input = "2\n" +
                "7\n" +
                "100 180 260 310 40 535 695\n" +
                "10\n" +
                "23 13 25 29 33 19 34 45 65 67";
        doBuyAndSellStock(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testSimple2() {
        String input = "1\n" +
                "84\n" +
                "886 2777 6915 7793 8335 5386 492 6649 1421 2362 27 8690 59 7763 3926 540 3426 9172 5736 5211 5368 2567 6429 5782 1530 2862 5123 4067 3135 3929 9802 4022 3058 3069 8167 1393 8456 5011 8042 6229 7373 4421 4919 3784 8537 5198 4324 8315 4370 6413 3526 6091 8980 9956 1873 6862 9170 6996 7281 2305 925 7084 6327 336 6505 846 1729 1313 5857 6124 3895 9582 545 8814 3367 5434 364 4043 3750 1087 6808 7276 7178 5788\n";
        doBuyAndSellStock(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testSimple3() {
        String input = "1\n" + "2\n" +
                "272 5";
        doBuyAndSellStock(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testSimple4() {
        String input = "1\n" + "89\n" +
                "6764 3645 5181 5893 4542 6753 3996 5483 585 9895 2657 777 1343 4605 261 2225 959 9884 563 4131 6687 7528 6224 436 3333 110 2037 7007 4710 2310 7596 7827 2307 9129 72 3202 2234 4069 5037 2819 3964 7694 9948 5307 8652 6561 7532 9611 6445 8095 94 9484 1975 6319 9920 5308 6429 1958 8668 7491 620 6264 5318 2927 1745 5391 6129 3979 5812 1167 3150 9776 8861 3098 5083 3865 9659 8968 3476 6104 3415 9923 1940 1743 6242 1861 3403 9023 3819\n";
        doBuyAndSellStock(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        new BuyAndSellStock().doBuyAndSellStock(System.in);
    }

    public void doBuyAndSellStock(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int a[] = new int[N];
                for (int j = 0; j < N; j++) {
                    a[j] = scanner.nextInt();
                }
                doBuyAndSellStock(N, a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void doBuyAndSellStock(int N, int[] a) {
        int localMax = 0;
        int localMin = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            if (a[localMin] > a[i]) localMin = i;
            if (a[localMax] < a[i]) localMax = i;
            if (i == N - 1 || a[i + 1] < a[i]) {
                if (localMax != localMin) sb.append(String.format("(%s %s) ", localMin, localMax));
                if (i < N - 1) localMax = localMin = i + 1;
            }
        }
        String output = sb.toString().trim();
        if(output.equals("")) output = "No Profit";
        System.out.println(output);
    }
    @Test
    public void test1() {
        doBuyAndSellStock(3, new int[]{2, 3, 1});
        doBuyAndSellStock(2, new int[]{2, 3});
        doBuyAndSellStock(1, new int[]{2});
        doBuyAndSellStock(2, new int[]{2, 1});
    }
}
