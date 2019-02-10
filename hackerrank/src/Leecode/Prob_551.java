package Leecode;

public class Prob_551 {
    public boolean checkRecord(String s) {
        if(s.length() <= 1) return true;

        int aCnt = 0;

        for (int i = 0; i < s.length();i++) {
            if(s.charAt(i) == 'A') {
                aCnt++;
                if(aCnt > 1) return false;
            }else if(s.charAt(i) == 'L') {
                if (i < s.length() - 2 && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        new Prob_551().checkRecord("PPALLL");
    }
}
