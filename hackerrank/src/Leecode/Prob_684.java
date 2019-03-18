package Leecode;

public class Prob_684 {
    int[] uf;
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        uf = new int[N + 1];
        for (int i = 0; i <= N; i ++) uf[i] = -1;

        for (int[] edge : edges) {
            int p = find(edge[0]);
            int q = find(edge[1]);

            if(p == q) return edge;

            union(p, q);

        }
        return null;

    }

    private int find(int p) {
        if(uf[p] == -1) {
            return p;
        }
        return find(uf[p]);
    }

    private void union(int p, int q) {
        int pSet = find(p);
        int qSet = find(q);
        uf[pSet] = qSet;
    }
}
