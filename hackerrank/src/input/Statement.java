package input;

import exchange.ExchangeMarket;

public abstract class Statement {

   public abstract void handle(final ExchangeMarket market);

}
