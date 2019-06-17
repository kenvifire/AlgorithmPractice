package Leecode;

import utils.AssertUtils;

public class Prob_10 {
    enum Type {
        CHAR,
        DOT,
        STAR,
        END;
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int idxS, String p, int idxP) {

        Character chS = idxS < s.length() ? s.charAt(idxS) : null;
        Character chP = idxP < p.length() ? p.charAt(idxP) : null;
        Character pNext = idxP + 1 < p.length() ? p.charAt(idxP + 1) : null;
//        Character pPrev = idxP - 1 >= 0 ? p.charAt(idxP - 1) : null;

        Type pType = getType(chP);
        Type nextType = getType(pNext);
        if (chS == null) {
            switch (pType) {
                case CHAR:
                case DOT:
                    switch (nextType) {
                        case STAR:
                            return isMatch(s, idxS, p, idxP + 2);
                        default:
                            return false;
                    }
                case STAR:
                    switch (nextType) {
                        case STAR:
                        case END:
                            return true;
                        default:
                            return false;
                    }
                case END:
                    return true;
                default:
                    return false;

            }

        } else {

            switch (pType) {
                case CHAR:
                    if (chS == chP) {
                        switch (nextType) {
                            case STAR:
                                return isMatch(s, idxS + 1, p, idxP)
                                        || isMatch(s, idxS, p, idxP + 2);
                            case DOT:
                            case CHAR:
                            case END:
                                return isMatch(s, idxS + 1, p, idxP + 1);

                            default:
                                return false;
                        }
                    } else {
                        switch (nextType) {
                            case STAR:
                                return isMatch(s, idxS, p, idxP + 2);
                            case DOT:
                            case CHAR:
                            case END:
                                return false;
                            default:
                                return false;
                        }
                    }

                case STAR:
                    return false;
                case DOT:
                    switch (nextType) {
                        case CHAR:
                        case DOT:
                        case END:
                            return isMatch(s, idxS + 1, p, idxP + 1);

                        case STAR:
                            return isMatch(s, idxS + 1, p, idxP)
                                    || isMatch(s, idxS, p, idxP + 2);
                        default:
                            return false;

                    }

                case END:
                    return false;
                default:
                    return false;
            }
        }


    }

    private Type getType(Character ch) {
        if (ch == null) {
            return Type.END;
        } else if (ch >= 'a' && ch <= 'z') {
            return Type.CHAR;
        } else if (ch == '.') {
            return Type.DOT;
        } else if (ch == '*') {
            return Type.STAR;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        Prob_10 prob = new Prob_10();
        AssertUtils.assertFalse(prob.isMatch("aa", "a"));
        AssertUtils.assertTrue(prob.isMatch("aa", "a*"));
        AssertUtils.assertTrue(prob.isMatch("aa", ".*"));
        AssertUtils.assertTrue(prob.isMatch("aab", "c*a*b"));
        AssertUtils.assertFalse(prob.isMatch("ssi", "s*"));
        AssertUtils.assertTrue(prob.isMatch("a", "ab*"));
        AssertUtils.assertFalse(prob.isMatch("ab", ".*c"));
        AssertUtils.assertFalse(prob.isMatch("a", "ab*a"));
        AssertUtils.assertTrue(prob.isMatch("bbbba", ".*a"));
        AssertUtils.assertTrue(prob.isMatch("bbbba", ".*a*a"));
    }
}
