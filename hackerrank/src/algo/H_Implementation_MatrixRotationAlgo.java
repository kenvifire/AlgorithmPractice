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

        int x = 0, y = 0, h = M, w = N, r = 0;
        int min = M < N ? M : N;

        while (R -- > 0) {
            while (x < min/2) {
                for (int i = 0; i < 2 * (M - 1) + 2 * (N - 1) - 1; i++) {
                    int[] index_a = getIndex(x, y, N, M, i);
                    int[] index_b = getIndex(x, y, N, M, i + 1);
                    int tmp = matrix[index_a[0]][index_a[1]];
                    matrix[index_a[0]][index_a[1]] = matrix[index_b[0]][index_b[1]];
                    matrix[index_b[0]][index_b[1]] = tmp;
                }
                x++;
                y++;
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static void rotation(int[][] matrix, int x, int y, int w, int h, int r) {
        r = r % (2 * w + 2 * h);


    }

    public static int[] getIndex(int x, int y, int w, int h, int i) {
        int[] index = new int[2];
        i  = i % (2 * w + 2 * h);
        if(i < w-1) {
            index[0] = x;
            index[1] = i;
        }else if(i >= w-1 && i < w+h-1) {
            index[0] = x + (i- w) + 1;
            index[1] = y + w -1;
        }else if(i >= w+h-1 && i < 2*w +h -2) {
            index[0] = x + h -1;
            index[1] = y + (2 * w +h - i ) - 3;
        }else {
            index[0]= x + (2*w + 2*h - i -4);
            index[1] = y;
        }
        return index;

    }
}
