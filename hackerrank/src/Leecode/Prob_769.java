package Leecode;

public class Prob_769 {
    public int maxChunksToSorted(int[] arr) {
        int currMax = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > currMax) {
                currMax = arr[i];
            }

            if(i >= currMax) {
                cnt++;
            }
        }
        return cnt;
    }
}
