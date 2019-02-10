package Leecode;

public class Prob_991 {
    public int brokenCalc(int X, int Y) {
        int ops = 0;

        while (Y > X) {
            ops++;
            if((Y & 1) == 1) Y ++ ;
            else Y >>=1;

        }

        return X - Y + ops;

    }


}
