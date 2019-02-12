package Leecode;

public class Prob_541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            int j = 0;
            int len = Math.min(k, s.length() - i);
            for (j = 0; j < len && i + j < s.length(); j++) {
                sb.append(s.charAt(i + len - j - 1));
            }
            i += j;

            for ( j = 0; j < k && i + j < s.length();j++) {
               sb.append(s.charAt(i + j));
            }
            i+=j;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Prob_541 prob = new Prob_541();
        System.out.println(prob.reverseStr("abcdefg", 2));
        System.out.println(prob.reverseStr("abcd", 1));
        System.out.println(prob.reverseStr("abcd", 2));
        System.out.println(prob.reverseStr("abcd", 3));
        System.out.println(prob.reverseStr("abcd", 4));
        System.out.println(prob.reverseStr("abcde", 4));
        System.out.println(prob.reverseStr("abcdef", 4));
        System.out.println(prob.reverseStr("abcdefg", 4));
        System.out.println(prob.reverseStr("abcdefgh", 4));
        System.out.println(prob.reverseStr("abcdefghi", 4));
        System.out.println(prob.reverseStr("abcdefghij", 4));
    }


}
