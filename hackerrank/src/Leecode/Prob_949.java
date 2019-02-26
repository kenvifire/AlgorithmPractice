package Leecode;

public class Prob_949 {
    public String largestTimeFromDigits(int[] A) {
        int max = -1;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A.length; j++) {
                if(j==i) continue;
                for (int k = 0; k < A.length; k++) {
                    if (i != k && k != j) {
                        int l = 6 - i - j - k;

                        int hour = 10 * A[i] + A[j];
                        int min = 10 * A[k] + A[l];

                        if (hour < 24 && min < 60) {
                            int time = hour * 60 + min;
                            if (time > max) max = time;
                        }
                    }
                }
            }
    }

    return max >=0 ? String.format("%02d:%02d", max/60, max %60) : "";

    }
}
