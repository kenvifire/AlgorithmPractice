package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.List;

public class Prob_38 {
    public String countAndSay(int n) {
        List<Integer> initLit = new ArrayList<>();
        initLit.add(1);

        for (int i = 1; i < n; i++) {
           initLit = generate(initLit);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initLit.size(); i++) {
            sb.append((char)(initLit.get(i) + '0'));
        }

        return sb.toString();
    }

    private List<Integer> generate(List<Integer> intList) {
        List<Integer> result = new ArrayList<>();
        int current = intList.get(0);
        int cnt = 1;

        for (int i = 1; i < intList.size(); i++) {
            if(intList.get(i) != current) {
                result.add(cnt);
                result.add(current);
                current = intList.get(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }

        result.add(cnt);
        result.add(current);

        return result;
    }

    public static void main(String[] args) {
        Prob_38 prob = new Prob_38();
        AssertUtils.equals("1", prob.countAndSay(1));
        AssertUtils.equals("11", prob.countAndSay(2));
        AssertUtils.equals("21", prob.countAndSay(3));
        AssertUtils.equals("1211", prob.countAndSay(4));
        AssertUtils.equals("111221", prob.countAndSay(5));
        AssertUtils.equals("312211", prob.countAndSay(6));
    }
}
