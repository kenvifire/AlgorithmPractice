package Leecode;

import utils.PrintUtils;

public class Prob_189 {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return;
        k = k % nums.length;

        int cnt = 0;
        for (int start = 0; cnt < nums.length; start++) {

            int current = start;

            int prev = nums[start];
            do {
                int i = (current +k ) % nums.length;
                int temp = nums[i];
                nums[i] = prev;
                prev = temp;
                current = i;
                cnt++;
            }while (start != current);
        }


    }

    public static void main(String[] args) {
        int[] num = new int[] {1,2,3,4,5,6,7};
        Prob_189 prob = new Prob_189();

        prob.rotate(num, 3);
        PrintUtils.printArray(num);
        num = new int[] {-1,-100,3,99};
        prob.rotate(num, 2);
        PrintUtils.printArray(num);

    }
}
