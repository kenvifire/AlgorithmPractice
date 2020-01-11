package Leecode;

public class Prob_44 {
    enum Type {
        CHAR,
        DOT,
        STAR,
        END;
    }
    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][s.length()];
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int idxS, String p, int idxP) {
        if(memo[idxS][idxP] != 0) return memo[idxS][idxP] == 1;

        Character chS = idxS < s.length() ? s.charAt(idxS) : null;
        Character chP = idxP < p.length() ? p.charAt(idxP) : null;
        Character pNext = idxP + 1 < p.length() ? p.charAt(idxP + 1) : null;

        Type pType = getType(chP);
        Type nextType = getType(pNext);
        if (chS == null) {
            switch (pType) {
                case CHAR:
                case DOT:
                    memo[idxS][idxP] = -1;
                    return false;
                case STAR:
                    switch (nextType) {
                        case STAR:
                            return isMatch(s, idxS, p, idxP+1);
                        case END:
                            memo[idxS][idxP] = 1;
                            return true;
                        default:
                            memo[idxS][idxP] = -1;
                            return false;
                    }
                case END:
                    memo[idxS][idxP] = 1;
                    return true;
                default:
                    memo[idxS][idxP] = -1;
                    return false;

            }

        } else {

            switch (pType) {
                case CHAR:
                    if (chS == chP) {
                        return isMatch(s, idxS+1, p, idxP+1);
                    } else {
                        memo[idxS][idxP] = -1;
                        return false;
                    }

                case STAR:
                    while(idxP + 1 < p.length() && p.charAt(idxP+1) == '*') idxP++;
                    return isMatch(s, idxS, p, idxP+1)
                            || isMatch(s, idxS+1, p, idxP);

                case DOT:
                    return isMatch(s, idxS+1, p, idxP+1);

                case END:
                    memo[idxS][idxP] = -1;
                    return false;
                default:
                    memo[idxS][idxP] = -1;
                    return false;
            }
        }


    }

    private Type getType(Character ch) {
        if (ch == null) {
            return Type.END;
        } else if (ch >= 'a' && ch <= 'z') {
            return Type.CHAR;
        } else if (ch == '.' || ch == '?') {
            return Type.DOT;
        } else if (ch == '*') {
            return Type.STAR;
        } else {
            return null;
        }
    }
}
