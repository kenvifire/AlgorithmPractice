package Leecode;

public class Prob_400 {
    public int findNthDigit(int n) {
        int cnt = 0;
        for (long i = 1; i < (1L << 31); i++) {
            String curr = String.valueOf(i);
            if(cnt + curr.length() < n) {
                cnt += curr.length();
            } else {
                return curr.charAt((n - cnt)) - '0';
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Prob_400 prob = new Prob_400();
        prob.findNthDigit(3);
    }
}
