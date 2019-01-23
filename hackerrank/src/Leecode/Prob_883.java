package Leecode;

public class Prob_883 {
    public int projectionArea(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
               if(grid[i][j] > 0)  {
                   area++;
               }
               if(grid[i][j] > max) {
                   max = grid[i][j];
               }
            }
            area += max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {

                if(grid[j][i] > max) {
                    max = grid[j][i];
                }
            }
            area += max;
        }

        return area;

    }

}
