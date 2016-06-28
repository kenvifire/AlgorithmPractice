package contest.w21;

import java.util.*;

/**
 * Created by kenvi on 16/6/28.
 */
public class LuckBalance {
    static class Contest implements Comparable<Contest> {
        int l, t;


        @Override
        public int compareTo(Contest o) {
            if (o.t == o.t) {
                return l - o.l;
            } else {
                return t - o.t;
            }
        }
    }

        public static void main(String[] args) {
            int N, K;
            Scanner scanner = new Scanner(System.in);
            N = scanner.nextInt();
            K = scanner.nextInt();

            int total = 0;
            List<Contest> contestList = new ArrayList<>();
            int l, t, importCnt = 0;
            for (int i = 0; i < N; i++) {

                l = scanner.nextInt();
                t = scanner.nextInt();
                Contest c = new Contest();
                c.l = l;
                c.t = t;
                if (t == 1) {
                    importCnt++;
                }
                total += l;
                contestList.add(c);

            }
            Collections.sort(contestList);
            int winCnt = K - importCnt;
            if (winCnt <= 0) {
                System.out.println(total);
                return;
            }

            for (int i = 0; i < winCnt; i++) {
                total -= 2 * contestList.get(i).l;
            }

            System.out.println(total);
        }

}
