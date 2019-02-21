package Leecode;

public class Prob_367 {
    public boolean isPerfectSquare(int num) {

        for (int i = 1; i * i > 0 && i * i < Integer.MAX_VALUE; i++) {
            System.out.println(i*i);
        }
        return false;
    }

    public static void main(String[] args) {
        Prob_367 prob = new Prob_367();
        prob.isPerfectSquare(1);
    }
}
