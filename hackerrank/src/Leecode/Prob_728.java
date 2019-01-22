package Leecode;

import java.util.ArrayList;
import java.util.List;

public class Prob_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i < right; i++) {
            int curr = i;
            while (curr > 0) {
                if(curr % 10 == 0)  break;
                int mod = curr % 10;
                if(i % mod != 0)  break;
                curr /= 10;
            }

            if (curr ==0 )list.add(i);
        }

        return list;

    }

    public static void main(String[] args) {
        new Prob_728().selfDividingNumbers(1, 22);
    }
}
