package input;


import exchange.ExchangeMarket;

public class InvalidStatement extends Statement {
    @Override
    public void handle(ExchangeMarket market) {
        System.out.println("I have no idea what you are talking about");
    }
}
