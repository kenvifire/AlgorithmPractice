package Leecode;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        if(n <= 1) return 0;
        int distance = 0;

        for (int i = 0; i < n - 1; i++) {
            int[] p1 = points[i];
            int[] p2 = points[i+1];

            int diffX = Math.abs(p1[0] - p2[0]);
            int diffY = Math.abs(p1[1] - p2[1]);

            distance += Math.min(diffX, diffY) + Math.abs(diffX - diffY);

        }

        return distance;
    }

}
