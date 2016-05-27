package ds;

import java.util.*;

/**
 * Created by kenvi on 16/5/27.
 */
public class H_DisjointSet_KunduAndTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        scanner.nextLine();
        String line = null;
        String[] array = null;
        int x,y;
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N+1);
        while (N --> 1) {
            line = scanner.nextLine();
            array = line.split(" ");
            x = Integer.valueOf(array[0]);
            y = Integer.valueOf(array[1]);
            if(array[2].charAt(0) == 'b') {
                uf.union(x, y);
            }

        }
        long n1 = 0, n2 = 0, n3 = 0;
        for (int i =1; i < uf.getSize() ; i++) {
            int size = uf.getComponentSize(i);
            if(size == 1) n1++;
            else if(size == 2) n2++;
            else if(size > 2) n3++;
        }

        long total = 0;
        //3 from red
        long mod = 1000000000+7;
        if(n1 >= 3) {
            total += (n1 * (n1-1) * (n1-2)/6);
        }

        //2 from red, one from black 2 or 3
        if(n1 >= 2) {
            total += (n1 * (n1 - 1) / 2) * (n2 + n3);
        }

        //1 from red, two from black (one from 2 and one from three)
        if(n1 >= 1) {
            total += (n1 * n2 * n3);
        }




        System.out.println(total%mod);




    }


    static class WeightedQuickUnionUF {
        private int[] id;
        private int[] sz;
        private boolean[] isBlack;
        private int count;
        private int size ;
        public WeightedQuickUnionUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
            }
            isBlack = new boolean[N];
            for (int i = 0; i < N; i++) {
                isBlack[i] = false;
            }
            size = N;

        }

        public int getSize() {
           return size;
        }


        public boolean isBlack(int p) {
            return isBlack[p];
        }
        private int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        public int getComponentSize(int p) {
            return sz[find(p)];

        }

        public void unionBlack(int p, int q) {
            isBlack[p] = true;
            isBlack[q] = true;
            union(p,q);

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
