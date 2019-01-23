package Leecode;

import java.util.Stack;

public class Prob_682 {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    int a = stack.pop();
                    int b = stack.peek();
                    stack.push(a);
                    stack.push(a + b);
                    break;
                case "D":
                    int c = stack.peek();
                    stack.push(c * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(ops[i]));
                    break;
            }

        }

        return stack.stream().reduce((a, b) -> a + b).get();
    }
}
