package contest.infinitum16;

import java.util.Scanner;

/**
 * Created by kenvi on 16/9/4.
 */
public class HyperspaceTravel {
    public static void main(String[] args) {
        int n,m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        double[] matrix = new double[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[j] += scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            matrix[i] = matrix[i] / n;
        }

        for (int i = 0; i < m; i++) {
            System.out.print((long)matrix[i] + " ");
        }

    }


}
