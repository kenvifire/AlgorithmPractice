package Leecode;

public class Prob_997 {

    public int findJudge(int N, int[][] trust) {
        int[][] judges = new int[N][2];
        for (int[] tr : trust) {
            judges[tr[1] - 1][0] ++;
            judges[tr[0] - 1][1] ++;
        }

        for (int i = 0; i < N; i++) {
            if(judges[i][0] == N - 1 && judges[i][1] == 0) return i + 1;
        }
        return -1;
    }

}
