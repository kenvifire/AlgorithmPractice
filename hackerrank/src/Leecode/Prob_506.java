package Leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob_506 {
    static class Point implements Comparable<Point> {
        int score,index;

        Point(int score, int index) {
            this.score = score;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            return -(this.score - o.score);
        }
    }
    public String[] findRelativeRanks(int[] nums) {
        String[] str = new String[nums.length];
        List<Point>  pointList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            pointList.add(new Point(nums[i],i));
        }

        Collections.sort(pointList);

        for (int i = 0; i < nums.length; i++) {
            Point point = pointList.get(i);
            if(i == 0) {
                str[point.index] = "Gold Medal";
            } else if(i == 1) {
                str[point.index] = "Silver Medal";
            } else if(i == 2) {
                str[point.index] = "Bronze Medal";
            }else {
                str[point.index] = String.valueOf(i + 1);
            }
        }
        return str;

    }
}
