package Leecode;

public class Prob_1022 {

    public int smallestRepunitDivByK(int K) {
        int x = 0;
        for (int i = 0; i < 100000; i++) {
            x = (x * 10 + 1);
            if(x % K == 0) return i + 1;
            x = x % K;
        }
        return -1;
    }



    public static void main(String[] args) {
        Prob_1022 prob = new Prob_1022();
        prob.smallestRepunitDivByK(10);
    }
}
