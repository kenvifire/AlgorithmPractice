package huawei;

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] ary = line.split(" ");
        if(ary.length == 0) {
            System.out.println(0);
        } else {
            System.out.println(ary[ary.length - 1].length());
        }
    }
}
