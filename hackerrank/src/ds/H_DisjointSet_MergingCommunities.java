package ds;

import java.util.Scanner;

/**
 * Created by kenvi on 16/5/26.
 */
public class H_DisjointSet_MergingCommunities {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int Q = scanner.nextInt();


        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N + 1);

        String line = null;
        scanner.nextLine();
        while( Q --> 0) {
            line = scanner.nextLine();
            String[] array = line.split(" ");
            int p,q;
            if(line.charAt(0) == 'M') {
                p = Integer.valueOf(array[1]);
                q = Integer.valueOf(array[2]);
                uf.union(p,q);
            }else {
                p = Integer.valueOf(array[1]) ;
                System.out.println(uf.getComponentSize(p));
            }
        }



    }

    static class WeightedQuickUnionUF {
        private int[] id;
        public int[] sz;
        public WeightedQuickUnionUF(int N) {
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

        public int getComponentSize(int p) {
            return sz[find(p)];

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
        }

    }
}
