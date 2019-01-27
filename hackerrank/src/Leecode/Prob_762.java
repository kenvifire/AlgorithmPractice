package Leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob_762 {

    private Set<Integer> primes = new HashSet<>();

    public int countPrimeSetBits(int L, int R) {

        primes.addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 13));

        int count = 0;

        int i = L;
        while (i <= R) {
            int cnt = bitCnt(i);
            if(primes.contains(cnt)) {
                count++;
            }
            i++;
        }
        return count;

    }

    private boolean isPrime(int x) {
        if(x == 1) return false;
        if(x == 2) return true;
        for (int i = 2; i <= Math.floor( Math.sqrt(x)); i++) {
            if(x % i == 0) return false;
        }
        return true;

    }



    private int bitCnt(int i) {
        int cnt = 0;
        while (i > 0) {
            if(i % 2 == 1) {
                cnt++;
            }
           i >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        new Prob_762().countPrimeSetBits(6, 10);
    }


}
