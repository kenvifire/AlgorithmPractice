package algo.sort;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/7/9.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        StringBuilder sb = null ;
        while (T-->0)  {
            sb = new StringBuilder(scanner.nextLine());
            int i = sb.length() - 1 ;
            while (i>0 && sb.charAt(i-1) >= sb.charAt(i) ) i--;
            if(i == 0) {
                System.out.println("no answer");
            }else {
                char head = sb.charAt(i-1);
                int j = sb.length() - 1;
                while (sb.charAt(j) <= head && j>=0) j--;
                System.out.println("swap:" + sb.charAt(i-1) +"|"+ sb.charAt(j));
                swap(sb, i - 1, j);
                String temp = new StringBuilder(sb.subSequence(i, sb.length())).reverse().toString();
                for (int m = 0; m+i <sb.length() ; m++) {
                   sb.setCharAt(m+i, temp.charAt(m));
                }
                System.out.println(sb.toString());
            }
        }

    }

    static void swap(StringBuilder sb, int a, int b) {
        char temp = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);
    }


}
