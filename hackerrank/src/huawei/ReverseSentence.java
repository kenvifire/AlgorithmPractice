package huawei;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            char[] charArray = line.toCharArray();
            reverse(charArray, 0, charArray.length);
            int start = 0;
            int len = 1;
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] == ' ') {
                    len = i - start;
                    reverse(charArray, start, len);
                    start = i + 1;
                }
            }
            reverse(charArray, start, charArray.length - start);
            System.out.println(new String(charArray));
        }
    }

    static void reverse(char[] arr, int start, int len) {
        int end = start + len;
        for(int i = 0; i < len/2; i++) {
            char temp = arr[start + i];
            arr[start + i] = arr[end - i - 1];
            arr[end - i - 1] = temp;
        }
    }
}
