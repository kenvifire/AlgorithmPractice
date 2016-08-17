package algo.greedy;

import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class LargestPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = scanner.nextInt();
        }
        int i = 0;
        while(K-->0 && i < N) {
            while(p[i] == N-i) {
                i++;
                if(i >= N) break;
            }
            if(i >= N) break;
            int index = findN(p, N-i, i);
            //swap
            int temp = p[index];
            p[index] = p[i];
            p[i] = temp;

        }
        for (int j = 0; j < N; j++) {
            System.out.printf(p[j] + " ");
        }



    }

    public static int findN(int[] p, int n, int startIndex) {
        for (int i = startIndex; i < p.length; i++) {
          if(p[i] == n)   return i;
        }
        throw new RuntimeException("Out of index");

    }
}
