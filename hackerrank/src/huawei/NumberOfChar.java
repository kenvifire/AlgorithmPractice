package huawei;

import java.util.Scanner;

public class NumberOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char ch = scanner.nextLine().charAt(0);
            int cnt = 0;
            for (char c : str.toCharArray()) {
                if(Math.abs(ch - c) == 32 || ch == c) {
                    cnt ++;
                }
            }
            System.out.println(cnt);
        }
    }
}
