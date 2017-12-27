package algo.hackrank.algo.uncategoried;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/22.
 */
public class H_String_TwoStrings {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[26];
        String s1,s2;
        while (T --> 0) {
            //init
            for (int i = 0; i < 26; i++) {
                arr[i] = 0;
            }
            s1 = scanner.nextLine();
            s2 = scanner.nextLine();
            for (int i = 0; i < s1.length(); i++) {
                int index = s1.charAt(i) - 'a';
                arr[index] = arr[index] + 1;
            }
            boolean flag = false;
            for (int i = 0; i < s2.length(); i++) {
                int index = s2.charAt(i) - 'a';
                if(arr[index] > 0) {
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                System.out.println("NO");
            }

        }
    }
}
