package Leecode;

public class Prob_204 {
    public int countPrimes(int n) {
        boolean isPrime[] = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;

        for (int i = 2; i * i < n; i++) {
            if(!isPrime[i]) {
                continue;
            }

            for (int j = i; i * j < n; j++) {
                isPrime[i * j] = false;
            }
        }

        int cnt = 0;
        for (int i = 0; i <isPrime.length; i++) cnt += isPrime[i] ? 1 : 0;
        return cnt;
    }
}
