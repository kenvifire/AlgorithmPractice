package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/8/17.
 */
public class GridChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        String line = null;
        while (T --> 0) {
            int N = scanner.nextInt();
            scanner.nextLine();
            char[][] matrix = new char[N][N];
            for (int i = 0; i < N; i++) {
                line = scanner.nextLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            for (int i = 0; i < N; i++) {
                Arrays.sort(matrix[i]);
            }
            boolean sorted = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - 1; j++) {
                    if (matrix[j][i] > matrix[j+1][i]) {

                        sorted = false;
                        break;
                    }
                }
                if(!sorted) break;

            }
            System.out.println(sorted ? "YES" : "NO");

        }


    }
}
