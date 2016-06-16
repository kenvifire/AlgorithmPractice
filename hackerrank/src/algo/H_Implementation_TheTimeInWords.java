package algo;

import java.util.Scanner;

/**
 * Created by hannahzhang on 16/6/16.
 */
public class H_Implementation_TheTimeInWords {
    public static void main(String[] args) {
        String[] numbers = new String[] {
                "one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve",
                "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
                "twenty one", "twenty two", "twenty three","twenty four","twenty five",
                "twenty six", "twenty seven", "twenty eight","twenty nine"
        };
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        if(m == 0) {
            System.out.println(numbers[h-1] + " o' clock");
        }else if(m <= 30) {
            if(m == 15) {
                System.out.println("quarter past " + numbers[h-1]);
            }else if(m == 30) {
                System.out.println("half past " + numbers[h-1]);
            }else if(m ==1) {
                System.out.println("one minute past " + numbers[h-1]);
            }else {
                System.out.println(numbers[m-1] + " minutes past " + numbers[h-1]);
            }
        }else {
            int left = 60 - m;
            if(left == 15) {
                System.out.println("quarter to " + numbers[h]);
            }else if(left == 1) {
                System.out.println("one minute to " + numbers[h]);
            }else {
                System.out.println(numbers[left-1] + " minutes to " + numbers[h]);
            }
        }

    }
}
