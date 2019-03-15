package Leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Prob_406 {
    static class  Point implements Comparable<Point> {
        int val, cnt;
        public Point(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point that) {
            if(this.cnt == that.cnt) {
                return that.val - this.val;
            }
            return this.cnt - that.cnt;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        List<Point> pointList = new LinkedList<>();
        for (int[] p :people) {
            pointList.add(new Point(p[0], p[1]));
        }

        Collections.sort(pointList);

        List<Point> resultList = new ArrayList<>();

        for (Point point: pointList) {

            resultList.add(point.cnt, point);
        }

        int[][] result = new int[people.length][2];

        for (int i = 0; i < resultList.size(); i++) {
            result[i][0] = resultList.get(i).val;
            result[i][1] = resultList.get(i).cnt;
        }
        return result;


    }

    public static void main(String[] args) {
        Prob_406 prob = new Prob_406();
        prob.reconstructQueue(new int [][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
}
