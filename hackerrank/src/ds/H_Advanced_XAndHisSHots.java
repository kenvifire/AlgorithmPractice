package ds;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/31.
 */
public class H_Advanced_XAndHisSHots {
    static class City implements Comparable<City>{
        int x,y;

        @Override
        public int compareTo(City o) {
            if(this.x != o.x ) return this.x - o.x;
            else return this.y - o.y;
        }
    }

    static class SegTree {
        long[] sum;
        SegTree(int N) {
            sum = new long[N << 2];
        }
        
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M,N;
        N = scanner.nextInt();
        M = scanner.nextInt();
        City[] shots = new City[N];
        City[] players = new City[M];

        int x, y;
        for (int i = 0; i < N; i ++ ) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            City segment = new City();
            segment.x = x;
            segment.y = y;
            shots[i] = segment;
        }

        for (int i = 0; i < M; i ++ ) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            City segment = new City();
            segment.x = x;
            segment.y = y;
            players[i] = segment;
        }

        Arrays.sort(shots);
        Arrays.sort(players);

        int total = 0;

        int i = 0, j = 0, current = 0;
        while (i < shots.length && j < players.length) {
            if(shots[i].y <= players[j].x) {
                current++;
                j++;
            }else {
                i++;
                total+=current;
                current--;

            }
        }
        System.out.println(total);
    }
}
