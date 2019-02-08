package Leecode;

public class Prob_746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;


        for (int i = 2; i <= cost.length; i++) {
                int cost1 = dp[i -1] + cost[i - 1];
                int cost2 = dp[i-2] + cost[i-2];
                dp[i] = cost1 < cost2 ? cost1 : cost2;

        }

        return dp[cost.length];
    }

    public static void main(String[] args) {
        System.out.printf("%d\n",new Prob_746().minCostClimbingStairs(new int[] {10, 15 ,20}));
        System.out.printf("%d\n",new Prob_746().minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }




}
