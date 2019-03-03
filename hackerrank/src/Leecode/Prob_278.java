package Leecode;

import utils.AssertUtils;

public class Prob_278 {
    private int x;
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if((((mid > 1 && !isBadVersion(mid-1)) || mid == 1) && isBadVersion(mid)) ) {
                return mid;
            }


            if(isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return 1;
    }

    boolean isBadVersion(int version) {
        return version >= x;
    }


    public static void main(String[] args) {
        Prob_278 prob = new Prob_278();
        prob.x = 6;
        AssertUtils.equals(6, prob.firstBadVersion(6));
        prob.x = 1;
        AssertUtils.equals(prob.x, prob.firstBadVersion(6));
        prob.x = 3;
        AssertUtils.equals(prob.x, prob.firstBadVersion(6));

    }
}
