package Leecode;

import utils.AssertUtils;

public class Prob_168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int mode = n % 26;
            if(mode == 0) {
                sb.append('Z');
                n--;
            }else {
                sb.append((char)(mode - 1 + 'A'));
            }
            n /= 26;

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Prob_168 prob = new Prob_168();
        AssertUtils.equals("A", prob.convertToTitle(1));
        AssertUtils.equals("Z", prob.convertToTitle(26));
        AssertUtils.equals("AA", prob.convertToTitle(27));
        AssertUtils.equals("AB", prob.convertToTitle(28));

    }
}
