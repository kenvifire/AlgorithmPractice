package Leecode;

public class Prob_999 {
    int[][] directions = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0,1}};
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1) break;
        }

        int cnt = 0;

        for (int[] direct : directions)  {
            int xHat = x;
            int yHat = y;
            while (xHat + direct[0] >= 0 && xHat + direct[0] < board.length
                    && yHat + direct[1] >= 0 && yHat + direct[1] < board[0].length) {
                xHat += direct[0];
                yHat += direct[1];
                char ch = board[xHat][yHat];
                if(ch == 'r' || ch == 'b' || ch == 'p') {
                   cnt++;
                   break;
                } else if(ch == 'R' || ch =='B' || ch == 'P') {
                    break;
                }
            }


        }

        return cnt;

    }
}
