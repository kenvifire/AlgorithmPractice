package Leecode;

import java.util.Stack;

public class Prob_32 {
    boolean[] flag;
    int N;
    public int longestValidParentheses(String s) {
        N = s.length();
        flag = new boolean[N];

        Stack<Integer> idxStack = new Stack<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
               stack.push(ch);
               idxStack.push(i);
            } else {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        int idx = idxStack.pop();
                        flag[idx] = true;
                        flag[i] = true;
                    }
                } else {
                    stack.push(ch);
                }
            }
        }

        int max = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if(flag[i]) {
                if(start == -1) {
                    start = i;
                }
                    end = i;
            } else {
                if(end - start + 1> max) {
                    max = end - start + 1;
                }
                end = -1;
                start = -1;
            }
        }

        if(end - start + 1 > max)  {
            max = end - start + 1;
        }
        return max > 1 ? max : 0;



    }


    public static void main(String[] args) {
        Prob_32 prob = new Prob_32();
        System.out.println(prob.longestValidParentheses(")()())"));
        System.out.println(prob.longestValidParentheses("(()"));
        System.out.println(prob.longestValidParentheses("((()"));
        System.out.println(prob.longestValidParentheses("((("));
        System.out.println(prob.longestValidParentheses(")))((("));
        System.out.println(prob.longestValidParentheses(")))((()"));
        System.out.println(prob.longestValidParentheses(")))))"));
        System.out.println(prob.longestValidParentheses("()(()"));
    }
}
