package algo.warmup;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kenvi on 16/10/8.
 */
public class MaximumPerimeterTriangle2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stickList = new int[n];
        for (int i = 0; i < n; i++) {
            stickList[i] = scanner.nextInt();
        }
        Arrays.sort(stickList);
        int p = n - 3;
        while (p >=0 && stickList[p] + stickList[p+1] <= stickList[p+2]) {
            p--;
        }

        if (p >= 0) {
            System.out.println(stickList[p] + " " + stickList[p+1] +" " + stickList[p+2]);
        }else {
            System.out.println(-1);
        }



    }
}
