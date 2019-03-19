package Leecode;

public class Prob_665 {
    public boolean checkPossibility(int[] nums) {
        if(nums.length <= 1) return true;

        int cnt = 0;
        int[] backwordNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) backwordNum[i] = nums[i];

        boolean forward = true;
        boolean backward = true;
        for (int i = backwordNum.length - 1; i > 0; i--) {
           if(backwordNum[i] < backwordNum[i-1]) {
               if(cnt == 0) {
                   backwordNum[i - 1] = backwordNum[i];
                   cnt++;
               }else {
                  backward = false;
                  break;
               }
           }

        }
        cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                if(cnt == 0) {
                    nums[i+1] = nums[i];
                    cnt++;
                } else {
                    forward = false;
                    break;
                }
            }
        }
        return forward || backward;
    }

    public static void main(String[] args) {
        Prob_665 prob = new Prob_665();
        prob.checkPossibility(new int[]{2,3,3,2,4});
    }
}
