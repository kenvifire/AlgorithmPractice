package algo.BitManipulation;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/17.
 */
public class MaximizingXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        int max = 0;
        for (int i = L; i <= R; i++) {
            for (int j = i+1; j <= R; j++) {
                if((i^j) > max)
                    max = i ^ j;
            }

        }
        System.out.println(max);
    }
}
