package Leecode;

public class Prob_686 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (; sb.length() < B.length() + A.length(); cnt++) {
            sb.append(A);
            if(sb.indexOf(B) >= 0) return cnt;
        }

        return sb.indexOf(B);
    }
}
