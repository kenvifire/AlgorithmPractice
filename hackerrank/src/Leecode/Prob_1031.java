package Leecode;

public class Prob_1031 {
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

    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(m * n + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i][j] == 0) continue;
                for (int[] direct : directions) {
                    int x = i + direct[0];
                    int y = j + direct[1];
                    if(x < 0 || x >= m || y < 0 || y >= n) {
                        uf.union(0, i * n + j);
//                        System.out.printf("connect %d,%d with border\n", i, j);
                    } else {
                        if(A[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
//                            System.out.printf("connect %d,%d with %d,%d\n", i, j, x, y);
                        }
                    }
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (A[i][j] == 1 && !uf.connected(0, i * n + j )) cnt ++;
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        Prob_1031 prob = new Prob_1031();
        System.out.println(prob.numEnclaves(new int[][] {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}));
        System.out.println(prob.numEnclaves(new int[][] {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}));
        System.out.println(prob.numEnclaves(new int[][] {{0,0,0,1,1,1,0,1,0,0},{1,1,0,0,0,1,0,1,1,1},{0,0,0,1,1,1,0,1,0,0},{0,1,1,0,0,0,1,0,1,0},{0,1,1,1,1,1,0,0,1,0},{0,0,1,0,1,1,1,1,0,1},{0,1,1,0,0,0,1,1,1,1},{0,0,1,0,0,1,0,1,0,1},{1,0,1,0,1,1,0,0,0,0},{0,0,0,0,1,1,0,0,0,1}}));
        System.out.println(prob.numEnclaves(new int[][] {{0,0,1,1,0,0,0,0,0,1},{1,1,0,1,0,0,1,0,0,1},{1,1,0,0,1,0,1,1,0,0},{1,0,0,1,0,0,0,0,0,1},{0,0,1,1,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{1,0,1,0,1,1,1,0,1,0},{0,1,1,1,0,0,1,0,0,1},{0,1,1,0,0,1,0,1,1,0},{1,0,1,1,0,0,1,1,0,0},{1,0,1,0,1,1,1,0,0,1}}));
    }





}
