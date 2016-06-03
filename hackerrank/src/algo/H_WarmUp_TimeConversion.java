package algo;

import java.util.Scanner;

/**
 * Created by kenvi on 16/6/3.
 */
public class H_WarmUp_TimeConversion {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        int hour = Integer.valueOf(sb.substring(0,2));
        String noon = sb.substring(8,10);
        if(noon.equals("AM") && hour == 12)  {
            hour = 0;
        }else if(noon.equals("PM") && hour == 12) {
            hour = 12;
        }else if(noon.equals("PM")) {
            hour += 12;
        }
        sb.setCharAt(0, (char)(hour/10 + '0'));
        sb.setCharAt(1, (char)(hour%10 +'0') );
        System.out.println(sb.substring(0,8));





    }
}
