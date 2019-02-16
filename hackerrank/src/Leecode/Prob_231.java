package Leecode;

public class Prob_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        int cnt = 0;

        while (n > 0) {
            if((n & 0x01) == 1) {
                cnt ++;
                if(cnt > 1) return false;
            }
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        new Prob_231().isPowerOfTwo(3);
    }
}
