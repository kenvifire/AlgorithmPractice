package search;

import java.util.Scanner;

/**
 * Created by kenvi on 16/8/16.
 */
public class ConnectedCell {
    public static int componentSize = 0;
    public static boolean[][] visited;
    public static int[][] delta = new int[][]{
        {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
    };
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        boolean[][] matrix = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = scanner.nextInt();
                matrix[i][j] = (v == 1);
            }
        }
        visited = new boolean[n][m];

        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                componentSize = 0;
                dfs(matrix,i,j,n,m);
                if(componentSize > maxSize) {
                    maxSize = componentSize;
                }
            }
        }

        System.out.println(maxSize);

    }

    private static void dfs(boolean[][] grid,int x, int y, int n, int m) {
        if(visited[x][y]) return;
        componentSize++;
        visited[x][y] = true;
        for (int i =0;i <delta.length;i++){
            int dx = x + delta[i][0];
            int dy = y + delta[i][1];
            if(dx >=0 && dx <= n-1 && dy >= 0 && dy <= m-1 && grid[x][y] && grid[dx][dy]) {
                dfs(grid, dx, dy, n, m);
            }
        }
    }
}
