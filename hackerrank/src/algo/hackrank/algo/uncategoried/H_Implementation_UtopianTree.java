package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/5.
 */
public class H_Implementation_UtopianTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N;
        while (T-->0) {
            N = scanner.nextInt();
            int result = 1;
            for (int i = 1; i <= N; i++) {
                if(i % 2 != 0) {
                    result *= 2;
                }else {
                    result += 1;
                }
            }
            System.out.println(result);
        }
    }

}
