package Leecode;

import utils.AssertUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob_532 {
    class Point {
        int x, y;
        public Point(int x , int y) {
            this.x = x;
            this.y = y;
            if(this.x > this.y) {
                int temp = this.x;
                this.x = this.y;
                this.y = temp;
            }
        }

        @Override
        public int hashCode() {
            return this.x * 31 + this.y;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            return this.x == other.x && this.y == other.y;

        }
    }

    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        Arrays.sort(nums);
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            int index = Arrays.binarySearch(nums, nums[i] + k);
            if(k != 0) {
                if(index > 0 && index != i) {
                    pointSet.add(new Point(nums[i], nums[index]));
                }
            } else {
                if( (i>0 && nums[i-1] == nums[i]) || (i < nums.length  -1&& nums[i] == nums[i+1]))  {
                    pointSet.add(new Point(nums[i], nums[i]));
                }
            }

        }
        return pointSet.size();
    }

    public static void main(String[] args) {
        Prob_532 prob = new Prob_532();
        AssertUtils.equals(2, prob.findPairs(new int[]{3,1,4,1,5}, 2));
        AssertUtils.equals(2, prob.findPairs(new int[]{3,3,3,1,4,1,5}, 0));
    }
}
