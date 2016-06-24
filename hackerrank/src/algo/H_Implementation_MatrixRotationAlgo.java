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
        int[][] dest = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }



            int x = 0, y = 0, m = M, n = N;
            int min = M < N ? M : N;
            while (x < min/2) {
                for (int i = 0; i < 2 * (m - 1) + 2 * (n - 1) ; i++) {
                    int[] index_a = getIndex(x, y, n, m, i);
                    int[] index_b = getIndex(x, y, n, m, i+R);
                    int tmp = matrix[index_a[0]][index_a[1]];
                    dest[index_b[0]][index_b[1]] = tmp;
//                    System.out.println(String.format("swap[%s]{%s,%s}->[%s]{%s,%s}",i,index_a[0],index_a[1],
//                            i+R,index_b[0],index_b[1]));
                }
                x++;
                y++;
                n-=2;
                m-=2;

            }


//        }
//        n-=2;
//        m-=2;
//        for (int i = 1; i < 2 * (m - 1) + 2 * (n - 1)-1; i++) {
//            int[] index = getIndex(1,1,2,2,i + R);
//            System.out.println(String.format("%s:{%s,%s}",i, index[0], index[1]));
//        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dest[i][j] + " ");
            }
            System.out.println();
        }


    }



    public static int[] getIndex(int x, int y, int w, int h, int i) {
        int[] index = new int[2];
        i  = i % (2 * (w-1) + 2 * (h -1));
        if(i < h-1) {
            index[0] = x + i;
            index[1] = y;
        }else if(i >= h-1 && i < w+h-1) {
            index[0] = x + h-1;
            index[1] = y + i - h + 1;
        }else if(i >= w+h-1 && i < 2*h +w -2) {
            index[0] = x + (2*h + w  - i-3);
            index[1] = y + w - 1;
        }else {
            index[0] = x;
            index[1] = x + (2*w + 2*h - i -4);
        }
        return index;

    }
}
