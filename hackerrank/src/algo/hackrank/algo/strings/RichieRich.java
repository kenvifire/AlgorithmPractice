package algo.hackrank.algo.strings;

import java.util.Scanner;

/**
 * Created by kenvi on 2018/1/1.
 */
public class RichieRich {
    static String richieRich(String s, int n, int k){
        int diff_count = 0;
        for(int i =0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                diff_count++;
        }
        if(diff_count > k)
            return "-1";

        StringBuilder result = new StringBuilder(s);

        int num = k;


        for (int i= 0; i < n/2 &&  num > diff_count; i++) {
            Character start = result.charAt(i);
            Character end = result.charAt(result.length() - i - 1);
            if(start != '9' && end != '9' && num >= (diff_count + 2) ) {
                result.setCharAt(i, '9');
                result.setCharAt(result.length() - i - 1, '9');
                num-=2;
            }else if((start == '9' && end !='9') || (start != '9' &&end == '9')) {
                result.setCharAt(i, '9');
                result.setCharAt(result.length() - i - 1, '9');
                num-=1;
            }else if(start != end) {
                result.setCharAt(i, '9');
                result.setCharAt(result.length() - i - 1, '9');
                num-=1;
            }
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                diff_count--;
            }
        }
        System.out.println(result);
        for (int i= 0; i < n/2 && num > 0; i++) {
            if(result.charAt(i) != result.charAt(result.length() - 1 - i)) {
                Character max = result.charAt(i) > result.charAt(result.length() - 1 - i) ? result.charAt(i) : result.charAt(s.length() - 1 - i);
                result.setCharAt(i, max);
                result.setCharAt(result.length() - 1 - i, max);
                num--;
            }
        }

        for (int i= 0; i < n/2 &&  num > 0; i++) {
            Character start = result.charAt(i);
            Character end = result.charAt(result.length() - i - 1);
            if(start != '9' && end != '9' && num >= 2) {
                result.setCharAt(i, '9');
                result.setCharAt(result.length() - i - 1, '9');
                num-=2;
            }else if((start == '9' && end !='9') || (start != '9' &&end == '9') && num >= 1) {
                result.setCharAt(i, '9');
                result.setCharAt(result.length() - i - 1, '9');
                num-=1;
            }
        }

        System.out.println(result);
        if(n % 2 == 1 && num > 0) result.setCharAt(n/2, '9');

        System.out.println(result);
        return result.toString();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}
