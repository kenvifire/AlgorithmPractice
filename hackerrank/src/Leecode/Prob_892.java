package Leecode;

public class Prob_892 {
    public int surfaceArea(int[][] grid) {
        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] > 0) {
                    sum += 4 * grid[i][j] + 2;
                }
                if(j > 0) {
                    if(grid[i][j] > 0 && grid[i][j-1] > 0) {
                        sum -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if(grid[j][i] > 0 && grid[j+1][i] > 0) {
                    sum -= Math.min(grid[j][i], grid[j + 1][i]) * 2;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        new Prob_892().surfaceArea(new int [][] {{1,0}, {0,2}});
    }
}
