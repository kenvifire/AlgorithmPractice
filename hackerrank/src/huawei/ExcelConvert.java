package huawei;

import java.util.Scanner;

public class ExcelConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.printf("%s ", toString(num));
        }
    }

    private static String toString(int num) {
        StringBuilder sb = new StringBuilder();
        while(num >= 1) {
            int r = num % 26;
            if (r != 0) {
                sb.append((char) ('a' + r - 1));
            }else {
                sb.append('z');
                num --;
            }

            num /= 26;
        }
        return sb.reverse().toString();
    }
}
