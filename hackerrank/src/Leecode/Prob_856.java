package Leecode;

import java.util.Stack;

public class Prob_856 {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if(ch == '(') {
                stack.push("(");
            }else {
                if(stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("1");
                } else {
                    int sum = 0;
                    while (!stack.empty() && !stack.peek().equals("(") && !stack.peek().equals(")")) {
                        sum += Integer.valueOf(stack.pop());
                    }
                    stack.pop();
                    sum = 2 * sum;
                    if (sum > 0)
                        stack.push(String.valueOf(sum));
                }
            }
        }

        int result = 0;
        while (!stack.empty()) {
            result += Integer.valueOf(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        Prob_856 prob = new Prob_856();
        prob.scoreOfParentheses("(())");
    }

}
