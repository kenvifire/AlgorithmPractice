package Leecode;

import utils.AssertUtils;

public class Prob_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        String s1 = a;
        String s2 = b;

        int carray = 0;

        int i = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        while (i < len2 || i < len1) {
           int current = carray;
           if(i < len1) {
               current += (s1.charAt((len1 - i - 1)) == '0' ? 0 : 1);
           }
           if(i < len2) {
               current += (s2.charAt(len2 - i - 1) == '0' ? 0 : 1);
           }

           if(current >= 2) {
               current -=2;
               carray =1;
           } else {
               carray = 0;
           }

           sb.append((char)(current + '0'));

           i++;
        }

        if(carray > 0) sb.append("1");

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Prob_67 prob = new Prob_67();

        AssertUtils.equals("10", prob.addBinary("1", "1"));
        AssertUtils.equals("11", prob.addBinary("10", "1"));
        AssertUtils.equals("11", prob.addBinary("1", "10"));
        AssertUtils.equals("100", prob.addBinary("11", "1"));
        AssertUtils.equals("10101", prob.addBinary("1010", "1011"));
    }
}
