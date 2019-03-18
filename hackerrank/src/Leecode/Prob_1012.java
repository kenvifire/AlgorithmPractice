package Leecode;

import utils.AssertUtils;

public class Prob_1012 {
    public int bitwiseComplement(int N) {
        String binary = Integer.toBinaryString(N);

        StringBuilder sb = new StringBuilder();
        for (char ch : binary.toCharArray()) {
            if(ch == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return Integer.valueOf(sb.reverse().toString(), 2);
    }

    public static void main(String[] args) {
        Prob_1012 prob = new Prob_1012();
        AssertUtils.equals(5, prob.bitwiseComplement(10));
        AssertUtils.equals(5, prob.bitwiseComplement(10));
        AssertUtils.equals(5, prob.bitwiseComplement(10));
    }
}
