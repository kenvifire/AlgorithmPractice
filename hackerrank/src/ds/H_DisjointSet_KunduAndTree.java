package ds;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Created by kenvi on 16/5/27.
 */
public class H_DisjointSet_KunduAndTree {

    public static void main(String[] args) throws Exception{
        //FileInputStream in = new FileInputStream(new File("/tmp/in"));
        //Scanner scanner = new Scanner(in);
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
        int size1 = 0;
        Map<Integer,Integer> componentSizeMap = new HashMap<>();
        for (int i =1; i <= uf.getSize() ; i++) {
            int root = uf.find(i);
            if(uf.getComponentSize(root) == 1) size1++;
            Integer value = componentSizeMap.get(root);
            if(value == null) {
                componentSizeMap.put(root, 1);
            }else {
                componentSizeMap.put(root, value+1);
            }
        }
        long size = uf.getSize();

        long mod = 1000000000+7;
        long total = size * (size - 1) * (size -2)/6;

        //remove black edged combinations
        for (Map.Entry<Integer, Integer> entry : componentSizeMap.entrySet()) {
            Long count = entry.getValue().longValue();
            //two black, one other
            if(count >= 2 ) {
                total -= count * (count -1 ) / 2 * (size - count);
            }

            if(count >= 3) {
                total -= count * (count - 1) * (count - 2) / 6;
            }
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
            for (int i = 1; i < N; i++) id[i] = i;
            sz = new int[N];
            for (int i = 1; i < N; i++) {
                sz[i] = 1;
            }
            isBlack = new boolean[N];
            for (int i = 1; i < N; i++) {
                isBlack[i] = false;
            }
            size = N - 1;
            count = N - 1;

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

        public int getComponentCount() {
            return count -1;
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
}
