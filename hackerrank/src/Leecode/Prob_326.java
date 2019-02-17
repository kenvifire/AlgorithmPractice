package Leecode;

public class Prob_326 {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;

        int cnt = 0;

        while (n > 0) {
            if(n % 3 == 2) return false;
            else if(n %3 == 1){
                cnt ++;
                if(cnt > 1) return false;
            }
            n /= 3;
        }

        return true;
    }

    public static void main(String[] args) {
        Prob_326 prob = new Prob_326();
        prob.isPowerOfThree(9);
    }
}
