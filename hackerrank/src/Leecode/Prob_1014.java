package Leecode;

import utils.AssertUtils;

public class Prob_1014 {
    public int shipWithinDays(int[] weights, int D) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int w : weights) {
            if(w > max) max = w;
            sum += w;
        }

        for (int capacity = max; capacity <= sum; capacity++) {
            if(canShip(weights, capacity, D)) {
                return capacity;
            }
        }
        return max;

    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int actualDays = 0;
        for(int i = 0; i < weights.length; ) {
            int current = 0;
            while (i < weights.length && current + weights[i] <= capacity) {
                current += weights[i];
                i++;
            }

            actualDays++;
            if(actualDays > days) return false;

        }

        return true;

    }

    public static void main(String[] args) {
        Prob_1014 prob = new Prob_1014();
//        AssertUtils.equals(15, prob.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
//        AssertUtils.equals(6, prob.shipWithinDays(new int[] {3,2,2,4,1,4}, 3));
//        AssertUtils.equals(3, prob.shipWithinDays(new int[] {1,2,3,1,1}, 4));
        AssertUtils.equals(602, prob.shipWithinDays(new int[] {147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47}, 10));
    }
}
