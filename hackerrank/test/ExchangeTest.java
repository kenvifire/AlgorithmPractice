import exchange.ExchangeMarket;
import input.InputProcessor;
import input.Statement;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class ExchangeTest {

    @Test
    public void test() {

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        final File input = new File("/Users/hannahzhang/code/OnlieJudge/hackerrank/src/tests/input");


        final InputProcessor inputProcessor = new InputProcessor();
        final List<Statement> statementList = inputProcessor.parse(input);

        ExchangeMarket exchangeMarket = new ExchangeMarket();

        exchangeMarket.handleStatement(statementList);


        Assert.assertEquals( "pish tegj glob glob is 42\n" +
                "glob prok Silver is 68 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "glob prok Iron is 782 Credits\n" +
                "prok prok Gold is 144500 Credits\n850.0\n", baos.toString());



    }
}
