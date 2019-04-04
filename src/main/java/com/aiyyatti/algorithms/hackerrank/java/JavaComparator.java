package com.aiyyatti.algorithms.hackerrank;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

// Write your Checker class here

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class JavaComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    public static void main(InputStream is) {
        Scanner scan = new Scanner(is);
        try {
            int n = scan.nextInt();

            Player[] player = new Player[n];
            Checker checker = new Checker();

            for (int i = 0; i < n; i++) {
                player[i] = new Player(scan.next(), scan.nextInt());
            }
            scan.close();

            Arrays.sort(player, checker);
            for (int i = 0; i < player.length; i++) {
                System.out.printf("%s %s\n", player[i].name, player[i].score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                scan.close();
                is.close();
            } catch (Exception e) {
            }
        }
    }

    static class Checker implements Comparator<Player> {
        @Override
        public int compare(Player p1, Player p2) {
            int score = -1 * Integer.valueOf(p1.score).compareTo(Integer.valueOf(p2.score));
            if (score == 0) return p1.name.compareTo(p2.name);
            else return score;
        }
    }

    @Test
    public void simpleTest() {
        String str = "5\n" +
                "amy 100\n" +
                "david 100\n" +
                "heraldo 50\n" +
                "aakansha 75\n" +
                "aleksa 150";
        main(new ByteArrayInputStream(str.getBytes()));
    }
}

