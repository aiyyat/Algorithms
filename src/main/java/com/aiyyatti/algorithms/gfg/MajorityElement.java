
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MajorityElement {
    @Test
    public void simpleTest() {
        System.out.println(doMajorityElement(new int[]{3, 1, 3, 3, 2}));
    }

    @Test
    public void simple2Test() {
        System.out.println(doMajorityElement(new int[]{1, 2, 0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 1, 0}));
    }

    public static void main(String[] args) {
        new MajorityElement().doMajorityElement(System.in);
    }

    public void doMajorityElement(InputStream is) {
        try {
            Scanner scanner = new Scanner(is);
            int T = scanner.nextInt();
            while (T-- > 0) {
                int N = scanner.nextInt();
                int input[] = new int[N];
                for (int i = 0; i < N; i++) input[i] = scanner.nextInt();
                System.out.println(doMajorityElement(input));
            }
        } catch (Exception e) {
            try {
                is.close();
            } catch (Exception e1) {
            }
            e.printStackTrace();
        }
    }

    public int doMajorityElement(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int prevElement = a[0];
        int prevCount = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == prevElement) prevCount++;
            else {
                if (prevCount > N / 2) return prevElement;
                prevCount = 1;
                prevElement = a[i];
            }
        }
        return (prevCount > N / 2) ? prevElement : -1;
    }
}
