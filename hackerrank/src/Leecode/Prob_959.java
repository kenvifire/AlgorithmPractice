package Leecode;

import utils.AssertUtils;

public class Prob_959 {
    int size = 0;
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int[] uf = new int[4 * N * N];
        size = 4 * N * N;

        for (int i = 0; i <  N; i ++) {
            for (int j = 0; j < N; j++) {
                int start = 4 * (i * N + j);
                uf[start] = start;
                uf[start + 1] = start + 1;
                uf[start + 2] = start + 2;
                uf[start + 3] = start + 3;
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int start = 4 * (i * N + j);
                if(j > 1) {
                    connect( start + 3, start - 3, uf);
                }
                if(i > 1) {
                    connect(start, start - 4 * N + 2, uf );
                }

                if(j < N - 1) {
                    connect(start + 1, start + 7, uf);
                }

                if(i < N - 1) {
                    connect(start + 2,start + 4 * N, uf);
                }

            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char ch = grid[i].charAt(j);
                int start = 4 * (i * N + j);

                switch (ch) {
                    case '/':
                        connect(start, start + 3, uf);
                        connect(start + 1, start + 2, uf);
                        break;
                    case '\\':
                        connect(start, start + 1, uf);
                        connect(start + 2, start + 3, uf);
                        break;
                    case ' ':
                        connect(start, start + 1, uf);
                        connect(start + 1, start + 2, uf);
                        connect(start + 2, start + 3, uf);
                        connect(start + 3, start, uf);
                        break;
                }
            }
        }
        return size;

    }

    private void connect(int p, int q, int[] uf) {
        int i = find(p, uf);
        int j = find(q, uf);

        if(i != j) {
            uf[i] = j;
            size --;
        }

    }

    private int find(int p, int[] uf) {
        while (uf[p] != p) {
            p = uf[p];
        }
        return p;
    }

    public static void main(String[] args) {
        Prob_959 prob = new Prob_959();
        AssertUtils.equals(3, prob.regionsBySlashes(new String[] {"//", "/ "}));
        AssertUtils.equals(5, prob.regionsBySlashes(new String[] {"/\\", "\\/"}));
        AssertUtils.equals(4, prob.regionsBySlashes(new String[] {"\\/", "/\\"}));
        AssertUtils.equals(2, prob.regionsBySlashes(new String[] {" /", "/ "}));
        AssertUtils.equals(1, prob.regionsBySlashes(new String[] {" /", "  "}));
    }


}
