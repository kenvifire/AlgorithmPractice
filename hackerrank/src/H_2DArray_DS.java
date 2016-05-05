/**
 * Created by kenvi on 16/5/5.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class H_2DArray_DS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int maxHG = Integer.MIN_VALUE;
        for (int arr_i = 0; arr_i <= 3; arr_i ++) {
            for (int arr_j = 0; arr_j <= 3; arr_j ++){
                int hg = getHourGlass(arr, arr_i, arr_j);
                if(hg> maxHG) {
                    maxHG = hg;
                }
            }
        }
        System.out.print(maxHG);
    }


    public static int getHourGlass(int[][] arr, int start_i, int start_j) {
        int sum = 0;
        sum += arr[start_i][start_j];
        sum += arr[start_i][start_j + 1];
        sum += arr[start_i][start_j + 2];
        sum += arr[start_i + 1][start_j + 1];
        sum += arr[start_i + 2][start_j];
        sum += arr[start_i + 2][start_j + 1];
        sum += arr[start_i + 2][start_j + 2];
        //System.out.println(String.format("%s,%s=>%s",start_i,start_j,sum));
        return sum;
    }
}
