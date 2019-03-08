package Leecode;

public class Prob_338 {
    public int[] countBits(int num) {
        int[] cnt = new int[num + 1];
        for (int i = 0; i <=num; i++) {
            int n = i;
            int currentCnt = 0;
            while (n> 0) {
                currentCnt += n & 0x01;
                n >>= 1;
            }
            cnt[i] = currentCnt;
        }
        return cnt;
    }


}
