package Leecode;

import utils.AssertUtils;

public class Prob_1013 {


    public int numPairsDivisibleBy60(int[] time) {
        if(time.length <= 1) return 0;
        int cnt = 0;
        int[] mode = new int[60];

        for (int i = 0; i < time.length ; i++) {
            int idx = time[i] % 60;
            mode[idx] +=1;
        }


        for (int i = 0; i <= 30; i++) {
            int idx = (60 - i) % 60;
            if(idx == i) {
                cnt += (mode[i] * (mode[i] - 1))/2;
            } else {
                cnt += mode[i] * mode[idx];
            }
        }
        return cnt;


    }

    public static void main(String[] args) {
        Prob_1013 prob = new Prob_1013();

        AssertUtils.equals(3, prob.numPairsDivisibleBy60(new int[]{60,60,60}));
        AssertUtils.equals(5, prob.numPairsDivisibleBy60(new int[]{30,20,150,100,40,20}));
        AssertUtils.equals(3, prob.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
