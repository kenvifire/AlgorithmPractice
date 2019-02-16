package Leecode;

public class Prob_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() -1;

        while (index1 >= 0 && index2 >= 0) {
            int current = (num1.charAt(index1) - '0' + num2.charAt(index2) - '0') + carry;
            if(current >= 10) {
                carry=1;
                current -=10;
            } else {
                carry = 0;
            }

            sb.append((char)('0' + current));
            index1--;
            index2--;
        }

        String left = num1;
        int index = index1;
        if(index2 >= 0) {
            left = num2;
            index = index2;
        }

        while (index >= 0) {
            int current = (left.charAt(index) - '0') + carry;
            if(current >= 10) {
                carry=1;
                current -= 10;
            } else {
                carry = 0;
            }
            sb.append((char)(current + '0'));
            index--;
        }
        if(carry > 0) sb.append((char)(carry + '0'));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new Prob_415().addStrings("999", "11");
    }
}
