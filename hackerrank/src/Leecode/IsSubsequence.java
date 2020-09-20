package Leecode;

/**
 * https://leetcode.com/submissions/detail/398349201/
 */
public class IsSubsequence {
    private boolean isSub(String s, int sIndex, String t, int tIndex) {
        if(s.length() == sIndex) return true;
        if((s.length() - sIndex) > (t.length() - tIndex)) return false;

        if(s.charAt(sIndex) == t.charAt(tIndex)) {
            return isSub(s, sIndex+1, t, tIndex+1) || isSub(s, sIndex, t, tIndex+1);
        } else {
            return isSub(s, sIndex, t, tIndex+1);
        }
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m+1][n+1];

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0) { dp[i][j] = true;}
                else if(i > j) { dp[i][j] = false;}
                else if(s.charAt(i - 1) == t.charAt(j - 1) ) {
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }

            }
        }
        return dp[m][n];

    }
}
