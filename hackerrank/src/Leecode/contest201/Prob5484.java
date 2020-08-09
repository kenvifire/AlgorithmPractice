package Leecode.contest201;

import java.util.BitSet;

public class Prob5484 {
    public char findKthBit(int n, int k) {
        int len = 1;
        for(int i = 1; i <= n - 1; i++) {
            len = 2 * len + 1;
        }

        BitSet bs = new BitSet(len);
        len = 1;
        bs.set(0, false);
        for(int i = 1; i <= n - 1; i++)  {
            bs.set(len, true);
            for(int j = 0; j < len; j++) {
               bs.set(len + j + 1, bs.get(j));
            }
            for (int j = 0; j < len; j++) {
                bs.set(j, !bs.get(len - j - 1));
            }
            len = 2 * len + 1;
        }
        return bs.get(len - k) ? '1' : '0';
    }

    public static void main(String[] args) {
        Prob5484 prob5484 = new Prob5484();
        System.out.println(prob5484.findKthBit(3,1));
        System.out.println(prob5484.findKthBit(4,11));
        System.out.println(prob5484.findKthBit(20,3));
    }
}
