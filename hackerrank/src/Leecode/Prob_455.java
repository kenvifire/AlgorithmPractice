package Leecode;

import java.util.Arrays;

public class Prob_455 {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int total = 0;

        int gIndex = g.length - 1;
        int sIndex = s.length - 1;
        while (gIndex >= 0 && sIndex >= 0) {
            if(g[gIndex] <= s[sIndex]) {
                total ++;
                gIndex--;
                sIndex--;
            } else {
                gIndex--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Prob_455 prob455 = new Prob_455();

        System.out.println(prob455.findContentChildren(new int[] {1,2}, new int[] {1,2,3}));
    }
}
