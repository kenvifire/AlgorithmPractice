package Leecode;

public class Prob_661 {
    private int[][] directions = new int[][] {{-1,-1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1,1}, {0,1}, {1,1}};
    public int[][] imageSmoother(int[][] M) {
        if(M.length == 0)  return M;
        int[][] N = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                float total = M[i][j];
                int cnt = 1;
                for (int[] direc : directions) {
                    int x = i + direc[0];
                    int y = j + direc[1];

                    if(x>=0 && x < M.length && y >= 0 && y < M[0].length) {
                        total += M[x][y];
                        cnt ++;
                    }
                }
                N[i][j] = (int)Math.floor(total / cnt);
            }
        }
        return N;
    }

    public static void main(String[] args) {
        Prob_661 prob = new Prob_661();
        prob.imageSmoother(new int[][] {{1}});
    }
}
