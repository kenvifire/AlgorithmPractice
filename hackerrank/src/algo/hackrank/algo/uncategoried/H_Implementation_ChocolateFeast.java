package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/8.
 */
public class H_Implementation_ChocolateFeast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int N,C,M,W,SUM;

        while (T-->0) {
            N = scanner.nextInt();
            C = scanner.nextInt();
            M = scanner.nextInt();
            W = 0;
            SUM = 0;

            SUM += N/C;
            W = N/C;
            while (W >= M) {
                SUM += W/M;
                W = W%M + W/M;
            }
            System.out.println(SUM);


        }
    }
}
