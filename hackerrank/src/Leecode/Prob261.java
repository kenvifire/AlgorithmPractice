package Leecode;

public class Prob261 {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        int[] uf = new int[n];
        for(int i = 0; i < n; i++) uf[i] = i;

        for(int[] edge: edges) {
            connect(uf, edge[0], edge[1]);
        }

        int size = 0;
        for(int i = 0; i < n; i++) {
            if(find(uf, i) == i) size++;
        }

        return size == 1;
    }

    private void connect(int[] uf, int p, int q) {
        int rootP = find(uf, p);
        int rootQ = find(uf, q);
        uf[rootP] = rootQ;
    }

    private int find(int[] uf, int p) {
        while(p != uf[p]) p = uf[p];
        return p;
    }
}
