package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/19.
 */
public class A_Implementation_LarryasArray {
    public static void main(String[] args) {
        int T, N;
        int[] a;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        while (T --> 0) {
             N = scanner.nextInt();
            a = new int[N];
            for (int i = 0; i < N; i++) {
               a[i] = scanner.nextInt();
            }
            if(checkArray(a)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            
        }

    }

    public static boolean checkArray(int[] array) {
        int A,B,C;
        for (int i = 0; i <= array.length - 3; i++) {
            A = array[i];
            B = array[i+1];
            C = array[i+2];
            if(A < B && B > C && A < C) {
                return false;
            }else if (A > B && B < C && A < C) {
                return false;
            }else if(A > B && B > C ) {
                return false;
            }

        }
        return true;
    }
}
