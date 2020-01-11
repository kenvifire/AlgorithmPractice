package exchange;

import input.DigitMapStatement;
import input.ExchangeStatement;
import input.PriceStatement;
import input.RomanNumberConverter;
import input.Statement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for exchange market, responsibilities:
 *  - Digit Mapping
 *  - Exchange
 */
public class ExchangeMarket {

    private final Map<String, Character> glaxyToRomanDigitMap;
    private final Map<String, Float> marketPrice;

    public Map<String, Character> getGlaxyToRomanDigitMap() {
        return glaxyToRomanDigitMap;
    }

    public Map<String, Float> getMarketPrice() {
        return marketPrice;
    }

    private RomanNumberConverter romanNumberConverter;

    public ExchangeMarket() {
        this.glaxyToRomanDigitMap = new HashMap<>();
        marketPrice = new HashMap<>();
        romanNumberConverter = new RomanNumberConverter();
    }

    public void addDigitMapping(String glaxyDigit, Character romanDigit) {
        glaxyToRomanDigitMap.put(glaxyDigit, romanDigit);
    }

    public void addMarketPrice(String glaxyUnit, Float price) {
        marketPrice.put(glaxyUnit, price);
    }

    public void handleStatement(final List<Statement> statementList) {
        statementList.forEach(statement -> statement.handle(this));

    }

    public int getIntFromRomanNumber(final String glaxyNumber) {
        StringBuilder romanNumber = new StringBuilder();
        for (String digit : glaxyNumber.split(" ")) {
            romanNumber.append(glaxyToRomanDigitMap.get(digit));
        }
        return romanNumberConverter.romanToNumber(romanNumber.toString());
    }
}
