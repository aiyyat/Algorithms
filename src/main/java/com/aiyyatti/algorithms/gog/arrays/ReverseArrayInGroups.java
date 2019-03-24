import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
 */
public class ReverseArrayInGroups {
    @Test
    public void testSimple() {
        reverseArrayInGroups(5, new int[]{1, 2, 3, 4, 5}, 3);
    }

    @Test
    public void testPart() {
        reverseArrayInGroups(2, new int[]{1, 2}, 3);
    }

    public static void main(String[] args) {
        new ReverseArrayInGroups().reverseArrayInGroups(System.in);
    }

    public void reverseArrayInGroups(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                int K = scanner.nextInt();
                int[] a = new int[N];
                for (int j = 0; j < N; j++) a[j] = scanner.nextInt();
                reverseArrayInGroups(N, a, K);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception ei) {
            }
        }
    }

    public void reverseArrayInGroups(int N, int[] a, int K) {
        int start = 0;
        N--;
        while (start < N) {
            int end = Math.min(N, start + K - 1);
            int mid = (start + end) / 2;
            for (int j = start; j <= mid; j++) {
                int temp = a[j];
                int refEnd = end + start - j;
                a[j] = a[refEnd];
                a[refEnd] = temp;
            }
            start = end + 1;
        }
        System.out.println(Arrays.stream(a).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
