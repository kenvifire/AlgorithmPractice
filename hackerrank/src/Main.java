import exchange.ExchangeMarket;
import input.InputProcessor;
import input.Statement;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String fileName = args[0];
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println(String.format("File [%s] dose not exist.", fileName));
            System.exit(-1);
        }
        InputProcessor inputProcessor = new InputProcessor();
        List<Statement> statementList = inputProcessor.parse(new File(fileName));

        ExchangeMarket exchangeMarket = new ExchangeMarket();
        exchangeMarket.handleStatement(statementList);
    }





}
