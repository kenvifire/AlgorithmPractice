package Leecode;

import utils.AssertUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Prob_739 {
    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> tempstack = new Stack<>();

        tempstack.push(0);

        for (int i = 1; i < T.length; i++) {
            int curr = T[i];
            while (!tempstack.isEmpty() && curr > T[tempstack.peek()]) {
                int top = tempstack.pop();
                result[top] = i - top;
            }
            tempstack.push(i);
        }
        while (!tempstack.isEmpty()) result[tempstack.pop()] = 0;
        return result;
    }

    public static void main(String[] args) {
        Prob_739 prob = new Prob_739();
        AssertUtils.equals(new int[] {1, 1, 4, 2, 1, 1, 0, 0}, prob.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        AssertUtils.equals(new int[] {0,0}, prob.dailyTemperatures(new int[]{73, 72}));
        AssertUtils.equals(new int[] {0}, prob.dailyTemperatures(new int[]{73}));
        AssertUtils.equals(new int[] {1,0,0,2,1,0,0,0,0,0}, prob.dailyTemperatures(new int[]{34,80,80,34,34,80,80,80,80,34}));
    }
}
