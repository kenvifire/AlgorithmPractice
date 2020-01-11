package Leecode;

public class Prob_50 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        else if(n == 1) return x;
        else if (n < 0)  {
            return 1/x * myPow(1/x, -(n-1));

        } else if((n & 0x02) == 0)  {
            return myPow(x, n >> 1) * myPow(x, n >> 1);
        } else {
            return myPow(x, n - 1) * x;
        }
    }
}
