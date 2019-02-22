package Leecode;

public class Prob_172 {
    public int trailingZeroes(int n) {
        int cnt = 0;

        for (long i = 5; i <= n; i*= 5) {
           cnt += n / i;
        }
       return cnt;
    }
}
