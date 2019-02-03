package Leecode;

public class Prob_860 {
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;

        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];
            if (bill == 20) {
                if(cnt10 > 0 && cnt5 > 0) {
                    cnt10 --;
                    cnt5--;
                } else if(cnt5 >= 3) {
                    cnt5 -=3;

                } else {
                    return false;
                }
            }else if(bill == 10) {
                if(cnt5 > 0) {
                    cnt5--;
                    cnt10++;
                } else {
                    return false;
                }
            } else {
                cnt5 ++;
            }
        }
        return true;


    }
}
