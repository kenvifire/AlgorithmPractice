package Leecode;

import utils.AssertUtils;

public class Prob_537 {
    public String complexNumberMultiply(String a, String b) {
        int idx = a.indexOf('+');
        int ax = Integer.valueOf(a.substring(0, idx));
        int ay = Integer.valueOf(a.substring(idx+1, a.length() - 1));
        idx = b.indexOf('+');
        int bx = Integer.valueOf(b.substring(0, idx));
        int by = Integer.valueOf(b.substring(idx+1, b.length() - 1));

        return String.format("%d+%di", (ax*bx - ay*by), (ax*by + ay*bx));
    }

    public static void main(String[] args) {
        Prob_537 prob = new Prob_537();
        AssertUtils.equals("0+-2i", prob.complexNumberMultiply("1+-1i", "1+-1i"));
        AssertUtils.equals("0+-0i", prob.complexNumberMultiply("0+-0i", "0+-0i"));
    }
}
