[1mdiff --git a/src/main/java/com/aiyyatti/algorithms/leetcode/GasStation.java b/src/main/java/com/aiyyatti/algorithms/leetcode/GasStation.java[m
[1mindex 6551943..d0cda20 100644[m
[1m--- a/src/main/java/com/aiyyatti/algorithms/leetcode/GasStation.java[m
[1m+++ b/src/main/java/com/aiyyatti/algorithms/leetcode/GasStation.java[m
[36m@@ -1,11 +1,12 @@[m
 package com.aiyyatti.algorithms.leetcode;[m
 [m
[32m+[m[32mimport org.junit.Test;[m
 import org.slf4j.Logger;[m
 [m
 import static org.slf4j.LoggerFactory.getLogger;[m
 [m
 /**[m
[31m- * Source: Cracking The Coding Interview.[m
[32m+[m[32m * Source: https://leetcode.com/problems/gas-station/[m
  * Time:[m
  * Todo:[m
  * Redo: Yes[m
[36m@@ -13,11 +14,39 @@[m [mimport static org.slf4j.LoggerFactory.getLogger;[m
  */[m
 public class GasStation {[m
     private static final Logger logger = getLogger(GasStation.class);[m
[32m+[m
     ///////////////[m
     // TEST CASE //[m
     ///////////////[m
[32m+[m[32m    @Test[m
[32m+[m[32m    public void testGasStation() {[m
[32m+[m[32m        System.out.println(findGasStation(new int[][]{[m
[32m+[m[32m                new int[]{1, 3},[m
[32m+[m[32m                new int[]{2, 4},[m
[32m+[m[32m                new int[]{3, 5},[m
[32m+[m[32m                new int[]{4, 1},[m
[32m+[m[32m                new int[]{5, 2}[m
[32m+[m[32m        }));[m
[32m+[m[32m    }[m
 [m
     //////////////[m
     // SOLUTION //[m
     //////////////[m
[32m+[m[32m    final private int GAS = 0;[m
[32m+[m[32m    final private int DIST = 1;[m
[32m+[m
[32m+[m[32m    public int findGasStation(int[][] milestones) {[m
[32m+[m[32m        int N = milestones.length;[m
[32m+[m[32m        nextmilestone:[m
[32m+[m[32m        for (int j = 0; j < N; j++) {[m
[32m+[m[32m            int balance = 0;[m
[32m+[m[32m            for (int i = 0; i < N; i++) {[m
[32m+[m[32m                int a = (i + j) % N;[m
[32m+[m[32m                balance += milestones[a][GAS] - milestones[a][DIST];[m
[32m+[m[32m                if (balance < 0) continue nextmilestone;[m
[32m+[m[32m            }[m
[32m+[m[32m            return j;[m
[32m+[m[32m        }[m
[32m+[m[32m        return -1;[m
[32m+[m[32m    }[m
 }[m
