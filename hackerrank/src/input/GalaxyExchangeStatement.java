package input;

import exchange.ExchangeMarket;

public class GalaxyExchangeStatement extends Statement {
    private String fromUnit;
    private String fromNumber;
    private String toUnit;

    public GalaxyExchangeStatement(final String fromNumber, final String fromUnit,
                                   final String toUnit) {
        this.fromNumber = fromNumber;
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
    }

    @Override
    public void handle(ExchangeMarket market) {
        int num = market.getIntFromRomanNumber(fromNumber);
        float fromPrice = market.getMarketPrice().get(fromUnit);
        float toPrice = market.getMarketPrice().get(toUnit);
        System.out.println(num * fromPrice / toPrice);

    }
}
