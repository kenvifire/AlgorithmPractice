package Leecode;

/**
 * https://leetcode.com/problems/paint-house/
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        if(costs.length ==0) return 0;
        int n = costs.length;
        int[][] minCost = new int[n][3];
        minCost[0] = costs[0];

        for(int i = 1; i < n; i++) {
            minCost[i][0] = Math.min(minCost[i-1][1], minCost[i-1][2]) + costs[i][0];
            minCost[i][1] = Math.min(minCost[i-1][0], minCost[i-1][2]) + costs[i][1];
            minCost[i][2] = Math.min(minCost[i-1][0], minCost[i-1][1]) + costs[i][2];

        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(minCost[n-1][i] < min) {
                min = minCost[n-1][i];
            }
        }
        return min;

    }
}
