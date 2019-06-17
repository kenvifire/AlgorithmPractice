package Leecode;

public class Prob_394 {
    enum TokenType {
        START,
        NUM,
        LEFT_BRACKET,
        RIGHT_BRACKET,
        STRING,
        END;
    }

    class Token {
        TokenType type;
        String val;

        int getLen() {
            return val.length();
        }
    }

    public String decodeString(String s) {
        return decodeString(s, 0, s.length() - 1);
    }


    private int findBound(String s, int start, int end) {
        int left = 0;
        int right = 0;
        for (int i = start; i <= end; i++) {
            if(s.charAt(i) == '[') {
                left++;
            } else if (s.charAt(i) == ']') {
                right++;
                if(left == right) return i;
            }
        }
        return end;
    }

    private String decodeString(String s, int start, int end) {

        Token token = getToken(s, start, end);
        switch (token.type) {
            case END:
                return "";
            case NUM:
                int num = Integer.valueOf(token.val);
                int rightBound = findBound(s, start + token.getLen(), end);
                StringBuilder sb = new StringBuilder();
                String left = decodeString(s, start + token.getLen() + 1, rightBound - 1);
                String right = decodeString(s, rightBound + 1 , end);

                for (int i = 0; i < num; i++) {
                    sb.append(left);
                }
                sb.append(right);
                return sb.toString();
            case STRING:
                return token.val + decodeString(s, start + token.getLen(), end);
            default:
                return "";
        }

    }


    private Token getToken(String s, int start, int end) {

        Token token = new Token();

        if (start > end || start >= s.length()) {
            token.type = TokenType.END;
            token.val = "";
            return token;
        }

        char ch = s.charAt(start);
        if (Character.isDigit(ch)) {
            token.type = TokenType.NUM;
            token.val = s.substring(start, s.indexOf('[',start));

        } else if (ch == '[') {
            token.type = TokenType.LEFT_BRACKET;
            token.val = "[";

        } else if (ch == ']') {
            token.type = TokenType.RIGHT_BRACKET;
            token.val = "]";
        } else {
            token.type = TokenType.STRING;
            int idx = -1;
            for (int i = start; i  <= end; i++) {
                char c = s.charAt(i);
                if(Character.isDigit(c) || c == '[' || c == ']') {
                   idx = i;
                   break;
                }
            }
            if (idx == -1) {
                idx = end + 1;
            }
            token.val = s.substring(start, idx);
        }

        return token;
    }

    public static void main(String[] args) {
        Prob_394 prob = new Prob_394();
        System.out.println(prob.decodeString("aaaa"));
        System.out.println(prob.decodeString("2[aaaa]"));
        System.out.println(prob.decodeString("2[aaaa]ccc"));
        System.out.println(prob.decodeString("3[2[abc]]ccc"));
        System.out.println(prob.decodeString("2[2[2[abc]]]ccc"));
        System.out.println(prob.decodeString("2[2[2[abc]]]ccc"));
        System.out.println(prob.decodeString("3[a]2[bc]"));
        System.out.println(prob.decodeString("3[a2[c]]"));
        System.out.println(prob.decodeString("2[abc]3[cd]ef"));
        System.out.println(prob.decodeString("3[a]2[b4[F]c]"));
         System.out.println(prob.decodeString("2[b4[F]c]"));
        System.out.println(prob.decodeString("2[4[F]c]"));
        System.out.println(prob.decodeString("3[a]2[bc]"));
    }


}
