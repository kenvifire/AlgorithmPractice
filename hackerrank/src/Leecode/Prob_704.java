package Leecode;

public class Prob_704 {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midValue = nums[mid];
            if(midValue < target) {
                start = mid + 1;
            }else if (midValue > target){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Prob_704 prob = new Prob_704();
        System.out.println(prob.search(new int[] {1},1 ));
        System.out.println(prob.search(new int[] {1, 2, 3},2 ));
        System.out.println(prob.search(new int[] {1, 2, 3},3 ));
        System.out.println(prob.search(new int[] {1, 2, 3},4 ));
    }
}
