package Leecode;

public class Prob_1006 {
    public int clumsy(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        if(N == 2) return 2;
        if(N == 3) return 6;
        long result = 0;
        int mode = N % 4;
        boolean flag = false;
        for(int x = N; x > mode; x -= 4) {
            if(!flag) {
                result += (x - 2) + 3 + x - 3;
                flag = true;
                if(x==4) result++;
            } else {
                result += -((x - 2) + 3) + x - 3;
                if(x==4) result--;
            }
        }

        if (mode == 1) {
            result = result - 1;
        } else if( mode == 2) {
            result = result - 2 * 1;
        } else if(mode == 3) {
            result =  result - 3 * 2/ 1;
        }

        return (int)result;
    }
}
