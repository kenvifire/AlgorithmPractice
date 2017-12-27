package algo.hackrank.algo.uncategoried;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by kenvi on 16/5/24.
 */
public class H_SimpleArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            sum += arr[arr_i];
        }

        System.out.printf(String.valueOf(sum));
    }
}
