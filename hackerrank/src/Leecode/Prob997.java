package Leecode;

public class Prob997 {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];
        int[] outDegree = new int[N + 1];

        for(int[] tr : trust) {
            int a = tr[0];
            int b = tr[1];
            inDegree[b]++;
            outDegree[a]++;
        }

        int judge = -1;
        for(int i = 1; i <= N; i++) {
            if(inDegree[i] == N- 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return judge;

    }
}
