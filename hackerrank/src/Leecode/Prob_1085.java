package Leecode;

public class Prob_1085 {
    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if(A[i] < min) {
                min = A[i];
            }
        }

        int sum = 0;

        while (min > 0) {
            sum += min % 10;
            min /= 10;
        }

        return sum % 2 == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Prob_1085 prob = new Prob_1085();
        System.out.println(prob.sumOfDigits(new int[] {34,23,1,24,75,33,54,8}));
        System.out.println(prob.sumOfDigits(new int[] {99,77,33,66,55}));
    }
}
