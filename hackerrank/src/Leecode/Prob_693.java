package Leecode;

public class Prob_693 {
    public boolean hasAlternatingBits(int n) {

        int last = n & 1;
        n >>= 1;
        while (n > 0) {
            if((last ^ (n & 1)) == 0 ) return false;
            last = (n & 1);
            n >>= 1;
        }
        return true;

    }

    public static void main(String[] args) {
        new Prob_693().hasAlternatingBits(5);
    }
}
