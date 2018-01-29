package algo.hackrank.algo.search;

import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/6.
 */
public class KnightLOnAChessboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solve(n);
    }

    public static void solve(int n){

        int[][] graph = new int[n][n];
        int[][][] pathTo = new int[n][n][2];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                for (int a = 0 ; a < n; a++) {
                    for (int b = 0; b < n; b++) {
                        graph[a][b] = 0;
                        pathTo[a][b][0] = -1;
                        pathTo[a][b][1] = -1;
                    }
                }
                graph[0][0]=1;
                pathTo[0][0][0]=-1;
                pathTo[0][0][1]=-1;
                dfs(graph,pathTo, n, 0, 0, 1, 3);
                System.out.print(count(pathTo, n) + " ");
            }
            System.out.println();
        }
    }

    public static int count(int[][][] pathTo, int n) {
        if (pathTo[n-1][n-1][0] == -1) return -1;

        int count = 0;
        int x = n-1;
        int y = n-1;
        while(pathTo[x][y][0] != -1 && pathTo[x][y][1] != -1) {
            int x_t = pathTo[x][y][0];
            int y_t = pathTo[x][y][1];
            x = x_t;
            y = y_t;
            count++;
        }
        return count;

    }

    public static void dfs(int[][] graph, int[][][] pathTo, int n, int x, int y , int i, int j) {
        if(x == n-1 && y == n-1) return;
        int[][] neighbours = getNeighbours(i, j);

        for (int k = 0; k < neighbours.length; k ++) {
            int[] neighbour = neighbours[k];
            int x_t = neighbour[0] + x;
            int y_t = neighbour[1] + y;

            if(x_t >= 0 && x_t < n && y_t >= 0 && y_t < n) {
                if(graph[x_t][y_t] == 0) {
                    graph[x_t][y_t] = 1;
                    pathTo[x_t][y_t][0] = x;
                    pathTo[x_t][y_t][1] = y;
                    dfs(graph,pathTo, n, x_t, y_t, i, j);
                }
            }
        }

    }

    public static int[][] getNeighbours(int i, int j) {
        int[][] neighbours = new int[8][2];
        neighbours[0] = new int[] { i, j};
        neighbours[1] = new int[] { i, -j};
        neighbours[2] = new int[] { -i, j};
        neighbours[3] = new int[] { -i, -j};
        neighbours[4] = new int[] { j, i};
        neighbours[5] = new int[] { j, -i};
        neighbours[6] = new int[] { -j, i};
        neighbours[7] = new int[] { -j, -i};

        return neighbours;
    }


}
