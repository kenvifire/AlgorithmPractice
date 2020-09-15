package huawei;

import java.util.Scanner;

public class NumberConvert {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String numStr = scanner.nextLine();
            int num = 0;
            int base = 1;
            for (int i = numStr.length() - 1; i >= 2; i --) {
                char ch = numStr.charAt(i);
                num += base * (Character.isDigit(ch) ? (ch - '0') : (ch - 'A' + 10));
                base *= 16;
            }
            System.out.println(num);
        }
    }
}
