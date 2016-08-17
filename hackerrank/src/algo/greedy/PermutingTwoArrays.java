package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class PermutingTwoArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q --> 0) {
            int n,k;
            n = scanner.nextInt();
            k = scanner.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = scanner.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B);

            boolean valid = true;
            for (int i = 0; i < n; i++) {
                if(A[i]+B[n-i-1] < k) {
                    valid =false;
                    break;
                }
            }
            System.out.println(valid ? "YES" : "NO");

        }
    }
}
