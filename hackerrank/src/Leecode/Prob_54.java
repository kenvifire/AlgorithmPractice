package Leecode;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length <= 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0 ; i <= m / 2  && j <= n / 2; i++, j++) {
            //top
            if(result.size() >= m * n) break;
            int x = i, y = j;
            for (; y <= n - i - 1; y++) {
                result.add(matrix[x][y]);
            }
            y--;
            x++;
            PrintUtils.printIntList(result);
            //right
            if(result.size() >= m * n) break;
            for (; x <= m - i - 1; x++) {
                result.add(matrix[x][y]);
            }
            x--;
            y--;
            PrintUtils.printIntList(result);
            //bottom
            if(result.size() >= m * n) break;
            for (; y >= i; y--) {
                result.add(matrix[x][y]);
            }
            y++;
            x--;
            PrintUtils.printIntList(result);
            //left
            if(result.size() >= m * n) break;
            for (; x > i; x--) {
                result.add(matrix[x][y]);
            }
            PrintUtils.printIntList(result);

        }

        return result;

    }

    public static void main(String[] args) {
        Prob_54 prob = new Prob_54();
        PrintUtils.printIntList(prob.spiralOrder(new int[][]{{1,2,3, 4},{5,6,7,8}, {9,10,11,12}}));
    }
}
