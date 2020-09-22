package Leecode;

/**
 * https://leetcode.com/problems/matrix-block-sum
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sumMatrix = new int[m][n+1];

        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += mat[i][j-1];
                sumMatrix[i][j] = sum;
            }
        }

        int[][] resultMatrix = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int up = Math.max(0, i - K);
                int down = Math.min(m-1, i+K);
                int left = Math.max(0, j - K);
                int right = Math.min(n, j+K + 1);

                int sum = 0;
                for(int l = up; l <= down; l++) {
                    sum+=sumMatrix[l][right] - sumMatrix[l][left];
                }
                resultMatrix[i][j] = sum;

            }
        }
        return resultMatrix;
    }
}
