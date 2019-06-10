package Leecode;


public class Prob_3_v1 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 1, len = 1;
        //
        for(int i = 1; i < s.length(); i++) {
            String subStr = s.substring(i - len, i);
            char c = s.charAt(i);
            if(!subStr.contains(c + "")) {
                len++;
            } else {
                if (max < len)
                    max = len;
                i = i - len +  1;
                len = 1;
            }
        }
        if(max < len) {
            max = len;
        }
        return max;

    }

    public static void main(String[] args) {
        Prob_3_v1 prob_3V1 = new Prob_3_v1();
    }
}
