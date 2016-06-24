package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/23.
 */
public class H_Implementation_MatrixRotationAlgo {

    public static void main(String[] args) {
        int M, N, R;
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        R = scanner.nextInt();
        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i <= 2 * M + 2 * N ; i++) {
            int[] index = getIndex(0,0, N, M, i);
            System.out.println(String.format("%s:{%s,%s}", i, index[0], index[1]));
        }


    }

    public static void rotation(int[][] matrix, int x, int y, int w, int h, int r) {
        r = r % (2 * w + 2 * h);


    }

    public static int[] getIndex(int x, int y, int w, int h, int i) {
        int[] index = new int[2];
        i  = i % (2 * w + 2 * h);
        if(i < w) {
            index[0] = x;
            index[1] = i;
        }else if(i > w && i <= w+h) {
            index[0] = x + (i- w);
            index[1] = y + w;
        }else if(i > w+h && i <= 2*w +h ) {
            index[0] = x + h;
            index[1] = y + (2 * w +h - i );
        }else {
            index[0]= x + (2*w + 2*h - i);
            index[1] = y;
        }
        return index;

    }
}
