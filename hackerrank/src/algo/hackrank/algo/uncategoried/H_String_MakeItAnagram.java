package algo.hackrank.algo.uncategoried;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/22.
 */
public class H_String_MakeItAnagram {
    public static void main(String[] args){
        String a,b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        b = scanner.nextLine();

        int[] arrA = new int[26];
        int[] arrB = new int[26];

        // init
        for (int i = 0; i < 26; i++) {
            arrA[i] = 0;
            arrB[i] = 0;
        }

        for (int i = 0; i < a.length(); i++) {
            int index = a.charAt(i) - 'a';
            arrA[index] = arrA[index] +1;
        }

        for (int i = 0; i < b.length(); i++) {
            int index = b.charAt(i) - 'a';
            arrB[index] = arrB[index] +1;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
           count += Math.abs(arrA[i] - arrB[i]);
        }

        System.out.println(count);


    }
}
