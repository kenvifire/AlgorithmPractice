package Leecode;

public class Prob_7 {
    public int reverse(int x) {
        String xStr = String.valueOf(x);
        boolean negative = (xStr.charAt(0) == '-');

        StringBuilder sb = new StringBuilder(xStr.length());
        for (int i = xStr.length() - 1 ; i >= (negative ? 1 : 0) ; i--) {
            sb.append(xStr.charAt(i));
        }

        Long value = Long.valueOf(sb.toString());
        if (negative) value = -value;
        long max = (1L << 31) - 1;
        long min = -(1L << 31);

        if (value <= max && value >= min) {
            return value.intValue();
        } else {
            return 0;
        }

    }
}
