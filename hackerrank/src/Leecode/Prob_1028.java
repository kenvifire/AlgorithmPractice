package Leecode;

public class Prob_1028 {
    public String baseNeg2(int N) {
        if(N == 0) return "0";
        int base = -2;
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int reminder = N % base;
            N /= base;

            if(reminder < 0) {
                reminder += (-base);
                N++;
            }
            sb.append(reminder);

        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Prob_1028 prob = new Prob_1028();
        System.out.println(prob.baseNeg2(2));
        System.out.println(prob.baseNeg2(3));
        System.out.println(prob.baseNeg2(4));
    }
}
