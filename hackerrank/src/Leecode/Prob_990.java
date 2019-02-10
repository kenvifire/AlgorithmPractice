package Leecode;

public class Prob_990 {
    static class WeightedQuickUnionUF {
        private int[] id;
        private int[] sz;
        private int count;
        public WeightedQuickUnionUF(int N) {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;

            sz = new int[N];
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
            }

        }

        private int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if(i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];

            } else {
                id[j] = i;
                sz[i] += sz[j];

            }
            count--;
        }

    }

    public boolean equationsPossible(String[] equations) {
        if(equations.length <= 1 ) return true;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(26);

        int[][] eq = new int[equations.length][2];
        int[][] notEq = new int[equations.length][2];
        int eqCnt = 0;
        int notEqCnt = 0;
        for (String equation: equations) {
            int x = equation.charAt(0) - 'a';
            int y = equation.charAt(3) - 'a';
            if(equation.charAt(1) == '=') {
                eq[eqCnt][0] = x;
                eq[eqCnt][1] = y;
                eqCnt++;
                uf.union(x,y);

            }else {
                notEq[notEqCnt][0] = x;
                notEq[notEqCnt][1] = y;
                notEqCnt++;
            }
        }

        for (int i = 0; i < notEqCnt; i++) {
           int x = notEq[i][0];
           int y = notEq[i][1];
           if(uf.connected(x, y)) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        Prob_990 prb = new Prob_990();
        System.out.println(prb.equationsPossible(new String[] {"a==b","b!=a"}));
        System.out.println(prb.equationsPossible(new String[] {"a==b"}));
        System.out.println(prb.equationsPossible(new String[] {"b==a","a==b"}));
        System.out.println(prb.equationsPossible(new String[] {"a==b","b==c","a==c"}));
        System.out.println(prb.equationsPossible(new String[] {"a==b","b!=c","c==a"}));
        System.out.println(prb.equationsPossible(new String[] {"c==c","b==d","x!=z"}));
    }




}
