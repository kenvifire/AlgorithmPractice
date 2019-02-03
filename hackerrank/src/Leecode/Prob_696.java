package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob_696 {
    public int countBinarySubstrings(String s) {
        if(s.length() == 0 || s.length() == 1) return 0;

        List<Integer> runLen = new ArrayList<>();

        char curr = s.charAt(0);
        int curCnt = 1;

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == curr) {
                curCnt ++;
            } else {
                runLen.add(curCnt);
                curr = s.charAt(i);
                curCnt = 1;
            }

        }
        runLen.add(curCnt);

        if (runLen.size() == 1) return 0;

        int cnt = 0;
        for (int i = 0; i < runLen.size() - 1; i++) {
            cnt += Math.min(runLen.get(i), runLen.get(i+1));
        }
        return cnt;

    }

    public static void main(String[] args) {
        new Prob_696().countBinarySubstrings("00110");
    }
}
