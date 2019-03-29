package Leecode;

import utils.AssertUtils;

public class Prob_861 {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        if(n == 0) return 0;

        for (int i = 0; i < m; i++) {
            if(A[i][0] == 0)  {
                for (int j = 0; j < n; j++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if(A[j][i] == 0 ) cnt ++;
            }

            if(cnt > m / 2) {
                for (int j = 0; j < m; j++) {
                    A[j][i] = A[j][i] == 0 ? 1 : 0;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            int idx = n - 1;

            for (int j = 0; j < n; j++) {
                sum += A[i][j] * (1 << idx);
                idx--;
            }

        }

        return sum;
    }

    public static void main(String[] args) {
        Prob_861 prob = new Prob_861();
        AssertUtils.equals(39, prob.matrixScore(new int [][] {{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }
}
