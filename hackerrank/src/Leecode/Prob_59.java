package Leecode;

import utils.PrintUtils;


public class Prob_59 {
    public int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][0];
        int len = n;
        int[][] matrix = new int[n][n];
        int current = 1;
        for (int i = 0; i <= len / 2 ; i++) {
            int x = i, y = i;
            //top
            for (; y <= len - i - 1; y++) {
               matrix[x][y] = current++;
            }
            y--;
            x++;
            //right
            for (; x <= len - i - 1; x++) {
                matrix[x][y] = current++;
            }
            x--;
            y--;
            //bottom
            for (; y >= i; y--) {
                matrix[x][y] = current++;
            }
            y++;
            x--;
            //left
            for (; x > i; x--) {
                matrix[x][y] = current++;
            }
        }

        return matrix;

    }

    public static void main(String[] args) {
        Prob_59 prob = new Prob_59();
        for (int i = 0; i < 5; i++) {
            PrintUtils.printArray(prob.generateMatrix(i));
        }
    }
}
