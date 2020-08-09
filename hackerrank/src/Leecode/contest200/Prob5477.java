package Leecode.contest200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob5477 {
    public int minSwaps(int[][] grid) {
        List<Integer> cntList = new ArrayList<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = n-1; j >=0; j--) {
                if(grid[i][j] == 0)  {
                    cnt ++;
                }else {
                    break;
                }
            }
            cntList.add(cnt);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            if(cntList.get(i) >= needed) continue;
            //else search next one and swap
            int idx = i + 1;
            while(idx < n && cntList.get(idx) < needed) {
                idx++;
            }
            if(idx == n) return -1;
            int last = cntList.get(idx);
            for(int j = idx; j >= i+1; j--) {
                cntList.set(j , cntList.get(j - 1));
            }
            cntList.set(i, last);


            cnt += idx - i;
        }


        return cnt;

    }

    public static void main(String[] args) {
        Prob5477 prob5477 = new Prob5477();
        prob5477.minSwaps(new int [][] {{0,0,1},{1,1,0},{1,0,0}});
    }
}
