package com.aiyyatti.algorithms.ctci.moderate;

import org.junit.Test;

/**
 * Living People: Given a list of people with their birth and death years, implement a method to
 * compute the year with the most number of people alive. You may assume that all people were born
 * between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should
 * be included in that year's count. For example, Person (birth = 1908, death = 1909) is included in the
 * counts for both 1908 and 1909.
 */
public class LivingPeople {
    @Test
    public void testSimple() {
        int[] birth = {1912, 1920, 1910, 1901, 1910, 1923, 1913, 1990, 1983, 1975};
        int[] death = {1915, 1990, 1998, 1972, 1998, 1982, 1998, 1998, 1999, 1994};
        System.out.println(doMaxAlive(birth, death));
    }

    @Test
    public void testSimple2() {
        int[] birth = {1900, 1970, 1950, 1900, 1910, 1915, 1919};
        int[] death = {1975, 2000, 1985, 1920, 1920, 1920, 1925};
        System.out.println(doMaxAlive(birth, death));
    }

    int START = 1900;
    int END = 2001;

    private int doMaxAlive(int[] birth, int[] death) {
        int N = END - START;
        int[] populationDiff = new int[N];
        for (int i = 0; i < birth.length; i++) {
            populationDiff[birth[i] - START] += 1;
            populationDiff[death[i] - START] -= 1;
        }
        for (int i = 1; i < N; i++) populationDiff[i] += populationDiff[i - 1];
        int maxAliveYear = 0;
        for (int i = 1; i < N; i++) {
            if (populationDiff[i] >= populationDiff[maxAliveYear]) {
                maxAliveYear = i;
            }
            System.out.printf("%s %s\n", START + i, populationDiff[i]);
        }

        return START + maxAliveYear;
    }
}
