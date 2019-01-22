package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pro_973 {
    static class Point implements Comparable<Point> {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x * this.x  + this.y * this.y - o.x * o.x - o.y * o.y;

        }
    }
    public int[][] kClosest(int[][] points, int K) {
        if(K >= points.length) return points;
        Point[] pointArray = new Point[points.length];

        for (int i = 0; i < points.length; i++){
            pointArray[i] = new Point(points[i][0], points[i][1]);
        }

        Arrays.sort(pointArray);

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i][0] = pointArray[i].x;
            result[i][1] = pointArray[i].y;

        }
        return result;

    }
}
