package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob_219 {
    static class Point implements Comparable<Point> {
        int val;
        int pos;

        public Point(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public int compareTo(Point o) {
            if(this.val == o.val) {
                return this.pos - o.pos;
            }

            return this.val - o.val;
        }
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            pointList.add(new Point(nums[i], i));
        }

        Collections.sort(pointList);

        for (int i = 0; i < pointList.size() - 1; i ++) {
            Point current = pointList.get(i);
            Point next = pointList.get(i + 1);

            if(current.val == next.val && Math.abs(current.pos - next.pos) <= k) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Prob_219 prob = new Prob_219();

        AssertUtils.assertTrue(prob.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
        AssertUtils.assertTrue(prob.containsNearbyDuplicate(new int[] {1,0,1,1}, 1));
        AssertUtils.assertFalse(prob.containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
    }
}
