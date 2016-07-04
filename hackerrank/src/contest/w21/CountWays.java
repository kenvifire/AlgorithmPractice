package contest.w21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/2.
 */
public class CountWays {
    static long[][] dp;
    static final long MOD = 1000000000 + 7;

    public static void main(String[] args) {
        int N;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        List<Integer> c = new ArrayList<>(N);


        for (int i = 0; i < N; i++) {
            c.add(scanner.nextInt());
        }

        long L,R;
        L = scanner.nextLong();
        R = scanner.nextLong();
        int bound = R >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)R;

        if(R > Integer.MAX_VALUE - 1) {
            dp = new long[(int)R + 1][c.size() + 1];
        }else {
            dp = new long[Integer.MAX_VALUE][c.size()+1];
        }

        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= c.size(); j++) {
                dp[i][j] = -1;
            }

        }

        long total = 0;
        for (long i = L; i <=R ; i++) {

            long result = combineDp(i, c) % MOD;
            total += result % MOD;
        }

        System.out.println(total%MOD);


    }

    private static long combineDp(long money, List<Integer> coins) {
        if(money > Integer.MAX_VALUE) {
            return countChange(money, coins);
        }else {
            return dpChange((int)money, coins.size(),coins);
        }
    }

    private static long countChange(long money, List<Integer> coins) {
        if(money < 0) {
            return 0;
        }else  if( money == 0) {
            return 1;
        }else if(coins.isEmpty()){
            return 0;
        }else {
            return countChange(money - coins.get(0),coins) % MOD
                    +
                    countChange(money, coins.subList(1,coins.size())) % MOD;
        }
    }

    private static long dpChange(int money, int size, List<Integer> coins ) {
        if(money < 0) {
            return 0;
        }else if(money == 0) {
            return  1;
        }else if(size == 0) {
            return 0;
        }else if(dp[money][size] != -1){
            return dp[money][size]%MOD;
        }else {
            dp[money][size] = combineDp(money,coins.subList(0,size-1)) % MOD +
                    combineDp(money - coins.get(size-1),  coins) % MOD;
            return dp[money][size] % MOD;
        }
    }
}
