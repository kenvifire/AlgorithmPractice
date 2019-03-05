package Leecode;

import utils.AssertUtils;

import java.util.PriorityQueue;

public class Prob_414 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if(pq.size() >= 3) {
                int top = pq.peek();
                if(current > top && !pq.contains(current)) {
                    pq.poll();
                    pq.offer(current);
                }
            } else {
                if(!pq.contains(current))
                    pq.offer(current);
            }
        }

        if(pq.size() < 3) {
            int last = -1;
            while (!pq.isEmpty()) last = pq.poll();
            return last;
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        Prob_414 prob = new Prob_414();

        AssertUtils.equals(1, prob.thirdMax(new int[] {3,2,1}));
        AssertUtils.equals(2, prob.thirdMax(new int[] {1,2}));
        AssertUtils.equals(1, prob.thirdMax(new int[] {2,2,3,1}));
    }
}
