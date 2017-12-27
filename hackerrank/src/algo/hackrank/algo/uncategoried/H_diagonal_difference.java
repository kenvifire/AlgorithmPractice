package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by kenvi on 16/5/24.
 */
public class H_diagonal_difference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int sum1 = 0;
        int sum2 = 0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
                if(a_i == a_j) {
                    sum1 += a[a_i][a_j];
                }

                if(a_i == n-1-a_j) {
                    sum2 += a[a_i][a_j];
                }
            }
        }
        int sum = sum1 - sum2;
        System.out.printf(String.valueOf(sum > 0 ? sum : -sum));
    }

}
