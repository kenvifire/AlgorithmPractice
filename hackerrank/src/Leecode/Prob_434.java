package Leecode;

import utils.AssertUtils;

public class Prob_434 {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        int cnt = 0;

        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flag = true;
            } else {
                if(flag) {
                    cnt ++;
                    flag = false;
                }
            }
        }
        if(flag) cnt++;

        return cnt;

    }

    public static void main(String[] args) {
        Prob_434 prob = new Prob_434();
        AssertUtils.equals(0, prob.countSegments("    "));
        AssertUtils.equals(1, prob.countSegments("  111  "));
        AssertUtils.equals(2, prob.countSegments("  111  222"));
        AssertUtils.equals(5, prob.countSegments("Hello, my name is John"));
    }
}
