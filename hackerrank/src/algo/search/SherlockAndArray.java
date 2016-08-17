package algo.search;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/15.
 */
public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T --> 0) {
            int N  = scanner.nextInt();
            int[] A = new int[N];
            for (int i =0; i<N; i++) {
                A[i] = scanner.nextInt();
            }
            System.out.println(hasIndex(A) ? "YES" : "NO");
        }
    }

    public static boolean hasIndex(int[] A){
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int leftSum = 0, rightSum = sum - A[0];
        if(leftSum == rightSum) return true;
        for (int i = 0; i < A.length-1 ; i++) {
            if(leftSum == rightSum)  return true;
            leftSum += A[i];
            rightSum -= A[i+1];
        }
        return false;
    }
}
