package com.aiyyatti.algorithms.hackerrank.java;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JavaBigDecimal {
    @Test
    public void simpleTest() {
        String input = "9\n" +
                "-100\n" +
                "50\n" +
                "0\n" +
                "56.6\n" +
                "90\n" +
                "0.12\n" +
                ".12\n" +
                "02.34\n" +
                "000.000";
        doJavaBigDecimal(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        new JavaBigDecimal().doJavaBigDecimal(System.in);
    }

    public void doJavaBigDecimal(InputStream is) {
        Scanner scanner = new Scanner(is);
        try {
            int N = scanner.nextInt();
            String[] input = new String[N + 2];
            for (int i = 0; i < N; i++) input[i] = scanner.next();
            doJavaBigDecimal(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                scanner.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public void doJavaBigDecimal(String[] s) {
        s = Arrays.copyOf(s, s.length - 2);
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return -1 * new BigDecimal(str1).compareTo(new BigDecimal(str2));
            }
        });
        System.out.println(Arrays.toString(s));
        Arrays.stream(s).forEach(e -> System.out.println(e));
    }
}
