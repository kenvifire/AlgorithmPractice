package input;

import exchange.ExchangeMarket;

public class PriceStatement extends Statement  {
    private final String fromNumber;
    private final String fromUnit;
    private final String toNumber;
    private final String toUnit;


    public PriceStatement(final String fromNumber, final String fromUnit,
                          final String toNumber, final String toUnit) {
        this.fromNumber = fromNumber.trim();
        this.fromUnit = fromUnit.trim();
        this.toNumber = toNumber.trim();
        this.toUnit = toUnit.trim();
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public String getToNumber() {
        return toNumber;
    }

    public String getToUnit() {
        return toUnit;
    }

    @Override
    public void handle(ExchangeMarket market) {
        int number = market.getIntFromRomanNumber(this.fromNumber);
        int creditValue = Integer.valueOf(this.toNumber);

        market.addMarketPrice(this.fromUnit, creditValue * 1.0f / number);
    }
}
