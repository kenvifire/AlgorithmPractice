package input;

import exchange.ExchangeMarket;

public class ExchangeStatement extends Statement {
    private String fromNumber;
    private String fromUnit;

    public ExchangeStatement(final String fromNumber) {
        this.fromNumber = fromNumber.trim();
    }

    public ExchangeStatement(final String fromNumber, final String fromUnit) {
        this.fromNumber = fromNumber.trim();
        this.fromUnit = fromUnit.trim();
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    @Override
    public void handle(ExchangeMarket market) {
        int num = market.getIntFromRomanNumber(this.fromNumber);
        if(this.fromUnit == null)  {
            System.out.println(String.format("%s is %d", this.getFromNumber(), num));
        } else {
            float price = market.getMarketPrice().get(this.fromUnit);
            System.out.println(String.format("%s %s is %.0f Credits", this.fromNumber,
                    this.fromUnit, num * price));
        }
    }
}
