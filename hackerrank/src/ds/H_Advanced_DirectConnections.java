package ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/1.
 */
public class H_Advanced_DirectConnections {

    static class City implements Comparable<City>{
        int l,p;

        @Override
        public int compareTo(City o) {
            return this.l - o.l;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int N;
        City[] cites;
        while(T --> 0) {
            long total = 0;
            N = scanner.nextInt();
            cites = new City[N];
            for (int i = 0; i < N; i++) {
                City city = new City();
                city.l = scanner.nextInt();
                cites[i] = city;
            }

            for (int i =0 ; i < N; i++) {
                City city = cites[i];
                city.p = scanner.nextInt();
            }
            Arrays.sort(cites);
            for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                    long max = Math.max(cites[i].p, cites[j].p);
                    long diff = cites[j].l - cites[i].l;
                    long current = max * diff;
                    total += current;

                }
            }
            System.out.println(total);
            System.out.println(total%1000000007);

        }
    }
}
