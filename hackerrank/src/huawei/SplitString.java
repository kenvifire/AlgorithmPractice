package huawei;

import java.util.Scanner;

public class SplitString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if(str.trim().length() == 0) continue;
            int start = 0;
            while (start < str.length()) {
                int end = start + 8 < str.length() ? start + 8 : str.length();
                String subStr = str.substring(start, end);
                System.out.print(subStr);
                for(int i = 1; i <= 8 - subStr.length(); i++) {
                    System.out.print('0');
                }
                System.out.println();
                start += 8;
            }
        }
    }
}
