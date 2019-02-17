package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob_849 {
    public int maxDistToClosest(int[] seats) {
        List<Integer> seated = new ArrayList<>();
        List<Integer> unseated = new ArrayList<>();

        int num =0;
        for (int seat : seats) {
            if(seat == 0) unseated.add(num++);
            else seated.add(num++);
        }

        int max = -1;

        for (int i: unseated) {
            int index = Collections.binarySearch(seated, i);
            index = -index - 1;
            int dist = Integer.MAX_VALUE;

            if(index >= 0 && index < seated.size()) {
                dist = Math.min(seated.get(index) - i, dist);
            }

            index -= 1;
            if(index >= 0 && index < seated.size()) {
                dist = Math.min(i - seated.get(index) , dist);
            }

            if(dist > max) max = dist;

        }
        return max;
    }

    public static void main(String[] args) {
        Prob_849 prob = new Prob_849();

        AssertUtils.equals(2, prob.maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
        AssertUtils.equals(1, prob.maxDistToClosest(new int[]{1,1,1,1,0,1}));
        AssertUtils.equals(1, prob.maxDistToClosest(new int[]{1,0,0,1,0,1}));
        AssertUtils.equals(3, prob.maxDistToClosest(new int[]{1,0,0,0}));
    }
}
