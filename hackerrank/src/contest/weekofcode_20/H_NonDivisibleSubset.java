package contest.weekofcode_20;
import java.util.*;

/**
 * Created by kenvi on 16/5/24.
 */
public class H_NonDivisibleSubset {

     public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         int n,k;
         n = scanner.nextInt();
         k = scanner.nextInt();
         int[] a = new int[n];

         for (int a_i = 0; a_i < n; a_i++) {
            a[a_i]  = scanner.nextInt();
         }

         int cnt = n;
         for (int a_i = 0; a_i < n; a_i++)  {
             for (int a_j = a_i+1; a_j < 0 ; a_j++) {
                 if((a[a_i] + a[a_j]) %k == 0) {
                 }

             }
         }


         //System.out.printf(String.valueOf(cnt[n][n-1]));

      }
}
