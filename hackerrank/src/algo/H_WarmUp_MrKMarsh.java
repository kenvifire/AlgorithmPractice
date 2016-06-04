package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_WarmUp_MrKMarsh {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] matrix = new int[M][N];
        String line ;
        scanner.nextLine();
        for (int i = 0; i < M; i++){
            line = scanner.nextLine();
            for(int j = 0;j < N; j++){
                if(line.charAt(j) == '.') {
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = -1;
                }
            }
        }
        int max = -1;
//        if(checkMarsh(matrix,0,0,M-1,N-1)) {
//            System.out.println(2*(M+N-2));
//            return;
//        }

        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N ; b++) {
                if(N * a - M*b > 0) continue; // only down triangle

                if(matrix[a][b]== -1) continue;//step on marsh
                for (int c = 0; c < M; c++) {
                     for (int d = 0; d < N; d++) {
                        if(N * c - M*d < 0) continue; // only down triangle
                        if(matrix[c][d] == -1) continue;// step on marsh
                        if(!checkMarsh(matrix,c,d,a,b)) continue; // has marsh
                        if(a!= c && b!=d) {
                            int p = 2*(Math.abs(a-c)  + Math.abs(b-d));
                            if(p > max) {
                                max = p;
                            }
                        }
                    }
                }
            }
        }

        if(max<=0) {
           System.out.println("impossible");
        }else{
            System.out.println(max);
        }

    }
    static boolean checkMarsh(int[][] matrix, int x, int y, int m, int n) {
        //(x,y) x--> (x,n)
        int max = y > n ? y : n;
        int min = y <n  ? y : n;
        for (int i =min; i <=max;i++ ) {
            if (matrix[x][i] == -1) return false;
        }
        //(m,y) --> (m,n)
        for (int i = min; i<= max; i++) {
            if(matrix[m][i] == -1) return false;
        }
        //(x,y) --> (m,y)
        max = x > m ? x : m;
        min = x < m ? x : m;
        for (int i = min; i<= max; i++) {
            if(matrix[i][y] == -1) return false;
        }
        //(x,n) --> (m,n)
        for (int i = min; i<= max; i++) {
            if(matrix[i][n] == -1) return false;
        }
        return true;

    }

}
