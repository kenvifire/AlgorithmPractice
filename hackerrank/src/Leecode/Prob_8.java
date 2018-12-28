package Leecode;

public class Prob_8 {
    public int myAtoi(String str) {
        boolean numberStart = false;
        boolean isValid = true;
        boolean negative = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);

            //White space
            if (currentChar == ' ') {
                if (!numberStart) {
                    continue;
                } else {
                    break;
                }
            } else if (currentChar == '-' || currentChar == '+') {
                if(!numberStart) {
                    numberStart = true;
                    if (currentChar == '-') negative = true;
                } else {
                    break;
                }


            }
            else if (Character.isDigit(currentChar)) {
                if (!numberStart) {
                    numberStart = true;
                }
                sb.append(currentChar);

            } else {
                if (!numberStart) {
                    isValid = false;
                    break;
                } else {
                    break;
                }
            }

        }


        long max = (1L << 31) - 1;
        long min = -(1L << 31);
        if (isValid) {
            Long value = 0L;
            try {
                if (sb.length() == 0) {
                    value = 0L;
                } else {
                    value = Long.valueOf(sb.toString());
                }
                if (negative) value = -value;
            }catch (NumberFormatException e) {
                value = negative ? min : max;
            }

            if (value <= max && value >= min) {
                return value.intValue();
            } else {
                return negative ? (int)min : (int)max;
            }
        } else {
            return 0;
        }
    }
}
