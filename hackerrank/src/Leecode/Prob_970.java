package Leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob_970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer>  result = new HashSet<>();

        for (int i = 0; i <= 18 && Math.pow(x,i) <= bound; i++) {
            for (int j = 0; j <= 18 && Math.pow(y, j) <= bound; j++) {
                int sum = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if(sum <= bound) result.add(sum);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(result);
        return resultList;
    }

    public static void main(String[] args) {
        Prob_970 prob = new Prob_970();

        prob.powerfulIntegers(2, 3, 10);
    }
}
