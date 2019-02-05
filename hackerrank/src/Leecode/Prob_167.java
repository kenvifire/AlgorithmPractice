package Leecode;

import java.util.Arrays;

public class Prob_167 {
    public int[] twoSum(int[] numbers, int target) {

        int[] index = null;
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            if(left > numbers[i]) {
                int searchIndex = Arrays.binarySearch(numbers,i+1, numbers.length  , left) ;
                if(searchIndex > 0) index = new int[] {i+1, searchIndex+1};
            } else if(left < numbers[i]){
                int searchIndex = Arrays.binarySearch(numbers,0, i , left) ;
                if(searchIndex > 0) index = new int[] {searchIndex+1, i+1};
            } else {
                if(i > 0 && numbers[i-1] == numbers[i])  index = new int[] {i, i+1};
                else if(i < numbers.length - 1 && numbers[i] == numbers[i+1]) index = new int[] {i+1, i+2};
            }
        }
        return index;

    }
}
