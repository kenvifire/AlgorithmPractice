package Leecode;

import utils.AssertUtils;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Prob_840 {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        if(row < 3 || column < 3) return 0;

        int cnt = 0;
        for (int i = 0; i <= row - 3; i ++) {
            for (int j = 0; j <= column - 3; j++) {
                cnt += isMagicSquares(grid, i, j) ? 1 : 0;
            }
        }
        return cnt;
    }

    private boolean isMagicSquares(int[][] grid, int x, int y) {
        Set<Integer> numSet = new HashSet<>();
        int sum = 0;
        for (int i = x; i < x + 3; i++ ) {
            sum = 0;
            for (int j = y; j < y + 3; j++) {
                sum += grid[i][j];
                if(grid[i][j] <= 9)
                    numSet.add(grid[i][j]);
            }
            if(sum != 15) return false;
        }
        if(numSet.size() != 9) return false;

        for (int i= y; i < y + 3; i++) {
            sum = 0;
            for (int j = x; j < x+3; j++) {
               sum += grid[j][i];
            }
            if(sum != 15) return false;
        }

        sum = 0;
        for (int i = 0; i < 3; i++) {
           sum += grid[x+i] [y+i];
        }

        if(sum != 15) return false;

        sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += grid[x+2 - i] [y+i];
        }

        return sum == 15;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        };

        Prob_840 prob = new Prob_840();
        AssertUtils.equals(1, prob.numMagicSquaresInside(grid));

        grid = new int[][] {
                {4,3,8,4},
                {9,5,1,9},
        };

        AssertUtils.equals(0, prob.numMagicSquaresInside(grid));

        grid = new int[][] {
                {5,5,5},
                {5,5,5},
                {5,5,5}
        };

        AssertUtils.equals(0, prob.numMagicSquaresInside(grid));

        grid = new int[][] {
                {1,8,6},
                {10,5,0},
                {4,2, 9}
        };

        AssertUtils.equals(0, prob.numMagicSquaresInside(grid));

        grid = new int[][] {
                {3,2,9,2,7},
                {6,1,8,4,2},
                {7,5,3,2,7},
                {2,9,4,9,6},
                {4,3,8,2,5}
        };

        AssertUtils.equals(1, prob.numMagicSquaresInside(grid));
    }

}
