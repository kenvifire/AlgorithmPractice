package Leecode;

import utils.AssertUtils;

public class Prob_419 {
    int cnt = 0;
    boolean[][] visited;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int countBattleships(char[][] board) {
        cnt=0;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X' && !visited[i][j]) {
                    cnt++;
                    dfs(board, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] board, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;

        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < board.length && y >=0 && y < board[0].length && board[x][y] == 'X') {
                dfs(board, x, y);
            }
        }

    }

    public static void main(String[] args) {
        Prob_419 prob = new Prob_419();
//        AssertUtils.equals(2, prob.countBattleships(new char[][]{"X..X".toCharArray(),"...X".toCharArray(), "...X".toCharArray()}));
        AssertUtils.equals(1, prob.countBattleships(new char[][]{"XX".toCharArray(),"XX".toCharArray(), "XX".toCharArray()}));
    }
}
