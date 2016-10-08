package algo.implementation;

import java.util.Scanner;

/**
 * Created by kenvi on 16/10/8.
 */
public class AbsolutePermutation {
    public static void main(String[] args) {
        int T, N, K;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        while (T-->0) {
            N = scanner.nextInt();
            K = scanner.nextInt();

            if(N % 2 == 1 && K >0) {
                System.out.println(-1);
                continue;
            }

            if(K > N/2 || (K!=0 && N % K != 0)) {
                System.out.println(-1);
                continue;
            }



            int[] p = new int[N+1];
            for (int i = 1; i <= N; i++) p[i] = i;
            if(K > 0) {
                int[] tmp = new int[K];
                for (int i = 1; i <= N; i += 2 * K) {
                    System.arraycopy(p, i, tmp, 0, K);
                    System.arraycopy(p, i + K, p, i, K);
                    System.arraycopy(tmp, 0, p, i + K, K);
                }
            }


            for (int i = 1; i<=N; i++) {
                System.out.print(p[i]+" ");
            }
            System.out.println();





        }
    }
}
