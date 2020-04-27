package Leecode.contest186;

public class Prob1 {
    public int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        for(char ch : s.toCharArray()) {
            if(ch =='0') zeros ++;
            if(ch == '1') ones ++;
        }
        int score = 0;
        int left = 0;
        int right = ones;
        for(int i = 0; i < s.length() - 1; i++ ) {
            if(s.charAt(i) == '0') {
                left ++;
            } else {
                right --;
            }
            int temp = left + right;
            if(temp > score) {
                score = temp;
            }
        }

        return score;

    }

    public static void main(String[] args) {
        Prob1 prob = new Prob1();
        System.out.println(prob.maxScore("011101"));
        System.out.println(prob.maxScore("00111"));
        System.out.println(prob.maxScore("1111"));
        System.out.println(prob.maxScore("0000"));
        System.out.println(prob.maxScore("00"));
        System.out.println(prob.maxScore("11"));
        System.out.println(prob.maxScore("10"));
        System.out.println(prob.maxScore("01"));
    }
}
