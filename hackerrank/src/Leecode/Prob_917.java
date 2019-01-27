package Leecode;

public class Prob_917 {
    public String reverseOnlyLetters(String S) {
        int left = 0, right = S.length() - 1;

        StringBuilder sb = new StringBuilder(S);
        while (left < right) {
            if (!Character.isAlphabetic(S.charAt(left))) {
                left++;
                continue;
            }

            if(!Character.isAlphabetic(S.charAt(right))) {
                right--;
                continue;
            }

            sb.setCharAt(left, S.charAt(right));
            sb.setCharAt(right, S.charAt(left));
            left++;
            right--;
        }
        return sb.toString();
    }
}
