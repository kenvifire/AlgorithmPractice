package Leecode;

public class Prob_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int N = minutesToTest / minutesToDie + 1;

        int base = 1;

        int cnt = 1;
        while (base < buckets) {
            base *= N;
            cnt ++;
        }

        return cnt;
    }
}
