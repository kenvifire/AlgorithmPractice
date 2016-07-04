package algo.dynamicProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/2.
 */
public class CoinChange {
    static long[][] dp;

    public static void main(String[] args) {
        int N,M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        List<Integer> c = new ArrayList<>(N);


        for (int i = 0; i < M; i++) {
            c.add(scanner.nextInt());
        }

         dp = new long[N+1][c.size()+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= c.size(); j++) {
                dp[i][j] = -1;
            }

        }
        dpChange(N, c.size(),c);
        System.out.println(dpChange(N, c.size(),c));


    }

    private static long dpChange(int money, int size, List<Integer> coins ) {
        if(money < 0) {
            return 0;
        }else if(money == 0) {
            return  1;
        }else if(size == 0) {
            return 0;
        }else if(dp[money][size] != -1){
            return dp[money][size];
        }else {
            dp[money][size] = dpChange(money,size-1, coins) +
                    dpChange(money - coins.get(size-1), size, coins);
            return dp[money][size];
        }
    }

    private static long countChange(int money, List<Integer> coins) {
        if(money < 0) {
            return 0;
        }else  if( money == 0) {
            return 1;
        }else if(coins.isEmpty()){
            return 0;
        }else {
            return countChange(money - coins.get(0),coins)
            +
                    countChange(money, coins.subList(1,coins.size()));
        }
    }
}
