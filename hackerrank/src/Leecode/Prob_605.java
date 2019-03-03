package Leecode;

import utils.AssertUtils;

public class Prob_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n <= 0) return true;
        int cnt = 0;
        int[] filledBed = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i ++) {
            filledBed[i+1] = flowerbed[i];
        }

        for (int i = 1; i < filledBed.length - 1; i++) {
           if(filledBed[i-1] == 0 && filledBed[i+1] == 0 && filledBed[i] != 1)  {
               cnt ++;
               filledBed[i] = 1;
               if(cnt >= n) return true;
           }
        }

        return false;


    }

    public static void main(String[] args) {
        Prob_605 prob = new Prob_605();

        AssertUtils.assertTrue(prob.canPlaceFlowers(new int[] {0, 0, 1}, 1));
        AssertUtils.assertTrue(prob.canPlaceFlowers(new int[] {0, 0, 1}, 0));
        AssertUtils.assertFalse(prob.canPlaceFlowers(new int[] {0,  1}, 1));
        AssertUtils.assertFalse(prob.canPlaceFlowers(new int[] {0,  1, 0}, 1));
        AssertUtils.assertTrue(prob.canPlaceFlowers(new int[] {0,  0, 0}, 2));
        AssertUtils.assertTrue(prob.canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        AssertUtils.assertFalse(prob.canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
    }
}
