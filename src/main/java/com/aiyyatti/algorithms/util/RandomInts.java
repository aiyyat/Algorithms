package com.aiyyatti.algorithms.util;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.Random;
import java.util.UUID;

@RunWith(Enclosed.class)
public class RandomInts {

    public static int[] dupsRandInts(int numberOfInts, int start, int end) {
        int[] a = new int[numberOfInts];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) a[i] = rand.nextInt(end - start) + start;
        return a;
    }

    public static int[] noDupsRandInts(int numberOfInts) {
        int[] a = new int[numberOfInts];
        for (int i = 0; i < a.length; i++) a[i] = i;
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int randomIndex = rand.nextInt(numberOfInts - i) + i;
            a[i] = a[randomIndex];
            a[randomIndex] = temp;
        }
        return a;
    }

    public static int[] readInts(String filename) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            return (int[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dupsRandIntsAsFile(int numberOfInts, int start, int end) {
        return asFile(dupsRandInts(numberOfInts, start, end));
    }

    private static String asFile(int[] a) {
        File file = new File(System.getProperty("java.io.tmpdir") + UUID.randomUUID() + ".algo");
        String filename = file.getAbsolutePath();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }

    public static class FileUtilsTest {
        @Test
        public void testRandomIntsAsFile() {
            System.out.println(noDupsRandInts(10000000));
        }
    }
}
