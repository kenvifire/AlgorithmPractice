package Leecode;

public class Prob_978 {
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 1) return 1;
        int[] order = new int[A.length-1];

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i+1]) order[i] = 0;
            else if (A[i] > A[i+1]) {
                order[i] = -1;
            }else {
                order[i] = 1;
            }
        }

        int max = 1;

        int i = 0;
        while (i < order.length) {
           int curMax = 1;
           int start = i;
           while (i < order.length -1 && order[i] !=0 &&  order[i+1] != 0&& order[i] != order[i+1] ) {
               i++;
               curMax++;
           }
           i++;
           if (curMax > max) {
               max = curMax;
           }

        }


        return max + 1;

    }

    public static void main(String[] args) {
        System.out.println(new Prob_978().maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
        System.out.println(new Prob_978().maxTurbulenceSize(new int[] {4,8,12,16}));
        System.out.println(new Prob_978().maxTurbulenceSize(new int[] {100}));
    }
}
