package Leecode.contest200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob5476 {
    public int getWinner(int[] arr, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int max = Arrays.stream(arr).max().getAsInt();

        for(int i = 0; i < arr.length; i++) {
            int idx = 1;
            int curr = arr[i];
            int cnt = 0;
            if(i > 0) {
                cnt += (arr[i] > arr[i-1]) ? 1 : 0;
            }
            while(idx < arr.length) {
                int next = (idx + i) % arr.length;
                if(arr[next] < curr) cnt++;
                else break;
                idx++;
            }
            cntMap.put(arr[i], cnt);
        }


        for(int i = 0; i < arr.length; i++) {
            if(cntMap.get(arr[i]) >= k) return arr[i];
        }

        return max;

    }

    public static void main(String[] args) {
        Prob5476 prob5476 = new Prob5476();
        prob5476.getWinner(new int[]{2,1,3,5,4,6,7}, 2);
    }
}

