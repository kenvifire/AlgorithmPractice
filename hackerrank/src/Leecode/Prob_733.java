package Leecode;

import utils.PrintUtils;

public class Prob_733 {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;

    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if(image[sr][sc] != oldColor) return;
        image[sr][sc] = newColor;

        for(int[] direction : directions) {
            int x = sr + direction[0];
            int y = sc + direction[1];

            if(x>=0 && x < image.length && y >=0 && y < image[0].length) {
                if(image[x][y] == oldColor) {
                    dfs(image, x, y, oldColor, newColor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        PrintUtils.printArray(new Prob_733().floodFill(image, 1, 1, 2));

        image = new int[][] {{0, 0, 0}, {0, 1, 1}};

        PrintUtils.printArray(new Prob_733().floodFill(image, 1, 1, 1));

    }

}
