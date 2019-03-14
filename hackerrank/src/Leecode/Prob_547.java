package Leecode;

import utils.AssertUtils;

public class Prob_547 {
    boolean visited[];

    boolean connected;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int size = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connected = false;
                dfs(M, i);
                if(connected) size ++;
            }
        }
        return size;

    }

    private void dfs(int[][]M, int n)  {
        if(visited[n]) return;
        visited[n] = true;

        for (int i = 0; i < M.length; i++) {
            if(M[n][i]==1) {
                connected = true;
                dfs(M, i);
            }
        }
    }

    public static void main(String[] args) {
        Prob_547 prob = new Prob_547();
        AssertUtils.equals(1, prob.findCircleNum(new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
        AssertUtils.equals(0, prob.findCircleNum(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
        AssertUtils.equals(1, prob.findCircleNum(new int[][] {{1,0,0},{0,0,0},{0,0,0}}));
    }
}
