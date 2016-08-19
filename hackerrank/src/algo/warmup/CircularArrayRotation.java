package algo.warmup;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/18.
 */
public class CircularArrayRotation {
    public static void main(String[] args) {
        int n,k,q;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        k = k %n;
        q = scanner.nextInt();
        int[] a = new int [n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m;
        while (q -- > 0) {
            m = scanner.nextInt();
            m = m % n;
            int index = m - k;
            if(index < 0) index += n;
            index = index % n;
            System.out.println(a[index]);
        }
    }
}
