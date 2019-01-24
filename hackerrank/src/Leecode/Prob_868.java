package Leecode;

public class Prob_868 {
    public int binaryGap(int N) {

        int distance = 0;
        int start = -1, end = -1;
        int i = 1;
        while (N > 0) {
            if((N & 0x01) == 1) {
                if(start == -1) {
                    start = i;
                    continue;
                } else {
                    end = i;
                    if(end - start > distance) {
                        distance = end - start;
                    }
                    start = i;
                }
            }
            N >>= 1;
            i++;
        }
        return distance;


    }
}
