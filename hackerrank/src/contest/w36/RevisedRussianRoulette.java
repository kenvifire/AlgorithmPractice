package contest.w36;

import java.util.Scanner;

/**
 * Created by kenvi on 2018/2/6.
 */
public class RevisedRussianRoulette {
    static int[] revisedRussianRoulette(int[] doors) {
        int[] result = new int[2];

        int min = 0;
        int max = 0;

        for (int i = 0; i < doors.length; i++) {
            int d = doors[i];
            if (d == 1) {
                min ++;
                max ++;
                if (i + 1< doors.length && doors[i+1] == 1) {
                   max++;
                    i++;
                }
            }


        }
        result[0] = min;
        result[1] = max;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] doors = new int[n];
        for(int doors_i = 0; doors_i < n; doors_i++){
            doors[doors_i] = in.nextInt();
        }
        int[] result = revisedRussianRoulette(doors);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
