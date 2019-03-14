package Leecode;

public class Prob_529 {

    int[][] cntBoard;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if(board[x][y] == 'E') {
            cntBoard = new int[board.length][board[0].length];
            initCntBoard(board, cntBoard);
            unreveal(board, x, y);
        }
        return board;
    }

    private void initCntBoard(char[][] board, int[][] cntBoard) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = 0;
                for (int[] direct : directions) {
                   int x = i + direct[0];
                   int y = j + direct[1];
                   if(x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                        cnt += (board[x][y]  == 'M' ? 1 : 0);
                   }
                }
                cntBoard[i][j] = cnt;
            }
        }
    }

    private void unreveal(char[][] board, int x, int y) {
        if(board[x][y] != 'E') return;

        if(cntBoard[x][y] != 0) {
            board[x][y] = (char)('0' + cntBoard[x][y]);
            return;
        }

        board[x][y] = 'B';
        for (int[] direction : directions) {
            int xHat = x + direction[0];
            int yHat = y + direction[1];

            if(xHat >= 0 && xHat < board.length && yHat >= 0 && yHat < board[0].length ) {
                unreveal(board, xHat, yHat);
            }
        }

    }

    public static void main(String[] args) {
        Prob_529 prob = new Prob_529();
        char[][] board = new char[][] {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        prob.updateBoard(board, new int[]{3,0});
    }
}
