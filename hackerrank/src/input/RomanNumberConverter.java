package input;

public class RomanNumberConverter {

    enum RomanDigit {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private final int value;

        private RomanDigit(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        /**
         * Get digit by symbol.
         *
         * @param symbol I, V, X, L, C, D & M
         * @return
         */
        public static RomanDigit getRomanDigit(char symbol) {
            String symbolStr = String.valueOf(symbol);

            return RomanDigit.valueOf(symbolStr);
        }
    }

    /**
     * Convert from Romain digit to int numbers
     *
     * @param s Roman digit
     * @return int value parsed from roman digit
     */
    public int romanToNumber(String s) {
        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            RomanDigit digit = RomanDigit.getRomanDigit(c);
            Character next = null;
            if (i < s.length() - 1) {
                next = s.charAt(i + 1);
            }

            RomanDigit nextDigit = next != null ? RomanDigit.getRomanDigit(next) : null;
            switch (digit) {
                case M:
                case D:
                case V:
                case L:
                    result += digit.getValue();
                    break;
                case C:
                case X:
                case I:
                    if (nextDigit != null && digit.getValue() < nextDigit.getValue()) {
                        result += (nextDigit.value - digit.value);
                        i++;
                    } else {
                        result += digit.value;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input:" + s);

            }
            i++;

        }
        return result;
    }
}
