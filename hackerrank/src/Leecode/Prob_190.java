package Leecode;

import utils.AssertUtils;

public class Prob_190 {
    public int reverseBits(int n) {
        long num = Integer.toUnsignedLong(n);
        long reversedValue = 0;
        int bitCnt = 0;
        while (num > 0) {
            reversedValue <<= 1;
            reversedValue += num & 0x01;
            num >>= 1;
            bitCnt++;
        }
        reversedValue <<= (32 - bitCnt) ;

        return (int)reversedValue;


    }

    public static void main(String[] args) {
        Prob_190 prob = new Prob_190();
        AssertUtils.equals(964176192, prob.reverseBits(43261596));
    }
}
