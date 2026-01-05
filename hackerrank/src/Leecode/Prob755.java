package Leecode;

import java.util.Arrays;

public class Prob755 {
    public int[] pourWater(int[] heights, int volume, int k) {


        for (int i = 0; i < volume; i++) {
            //left;
            int j = k;
            int left = k;
            while (j-1 >= 0 && heights[j - 1] <= heights[j]) {
                if(heights[j-1] < heights[j]){
                    left = j-1;
                }
                j--;
            }

            int right = k;
            j = k;
            while (j + 1 < heights.length && heights[j + 1]  <= heights[j]) {
                if(heights[j+1] < heights[j]){
                    right = j+1;
                }
                j++;
            }
            if(left < k) {
                heights[left] +=  1;
            } else if(right >k ) {
                heights[right] +=  1;
            } else {
                heights[k] +=  1;
            }
        }
        return heights;

    }

    public static void main(String[] args) {
        Prob755 p = new Prob755();
        int[] heights = {1,2,3,4,3,2,1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(p.pourWater(heights, 5, 5)));
    }
}
