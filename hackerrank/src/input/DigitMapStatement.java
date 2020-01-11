package input;


import exchange.ExchangeMarket;

public class DigitMapStatement extends Statement {

    private final String fromDigit;
    private final String toDigit;

    public DigitMapStatement(final String fromDigit, final String toDigit) {
        this.fromDigit = fromDigit.trim();
        this.toDigit = toDigit.trim();
    }

    public String getFromDigit() {
        return fromDigit;
    }

    public String getToDigit() {
        return toDigit;
    }

    @Override
    public void handle(final ExchangeMarket market) {
        market.addDigitMapping(this.fromDigit, this.toDigit.charAt(0));
    }
}
