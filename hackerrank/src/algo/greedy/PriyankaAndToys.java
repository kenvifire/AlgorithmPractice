package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kenvi on 16/8/17.
 */
public class PriyankaAndToys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = scanner.nextInt();
        }

        Arrays.sort(w);
        int count = 0;
        int current = 0;
        for (int i = 0; i < N; ) {
            current = w[i];
            count++;
            while (i < N && w[i] <= current+4) i++;
        }

        System.out.println(count);



    }
}
