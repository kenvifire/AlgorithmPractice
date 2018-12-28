package Leecode;

public class Prob_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String xStr = String.valueOf(x);

        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - i -1)) {
                return false;
            }

        }
        return true;

    }
}
