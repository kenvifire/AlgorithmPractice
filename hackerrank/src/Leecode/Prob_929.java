package Leecode;

import java.util.HashSet;
import java.util.Set;

public class Prob_929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email: emails) {
            emailSet.add(processEmail(email));
        }

        return emailSet.size();

    }

    public String processEmail(String email) {
        StringBuilder sb = new StringBuilder();

        boolean skip = false;
        boolean isDomain = false;
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            switch (ch) {
                case '.':
                    if(isDomain) sb.append(ch);
                    break;
                case '@':
                    isDomain = true;
                    skip = false;
                    sb.append(ch);
                    break;
                case '+':
                    skip = true;
                    break;
                default:
                    if (!skip) sb.append(ch);
                    break;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.printf(new Prob_929().processEmail("test.email+alex@leetcode.com\n"));
        System.out.printf(new Prob_929().processEmail("test.e.mail+bob.cathy@leetcode.com\n"));
        System.out.printf(new Prob_929().processEmail("testemail+david@lee.tcode.com\n"));
    }
}
