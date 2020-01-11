package input;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputProcessor {

    private static final Pattern DIGIT_MAP = Pattern.compile("^(\\w+) is (.)$");
    private static final Pattern PRICE_MAP = Pattern.compile("^((\\w+\\s)+)(\\w+) is (\\d+) (\\w+)$");
    private static final Pattern DIGIT_MAP_REQ = Pattern.compile("^how much is ((\\w+\\s)+)\\?$");
    private static final Pattern PRICE_MAP_REQ = Pattern.compile("^how many Credits is ((\\w+\\s)+)(\\w+) \\?$");
    private static final Pattern GALAXY_EXH_REQ = Pattern.compile("how many (\\w+) is ((\\w+\\s)+)(\\w+) \\?");

    public List<Statement> parse(final File file) {

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            List<Statement> statementList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                statementList.add(parseStatement(line));
            }

            return statementList;
        } catch (final IOException ex) {
            throw new RuntimeException("Exception reading file.");
        }
    }

    public Statement parseStatement(final String input) {
        Matcher matcher = DIGIT_MAP.matcher(input);

        if (matcher.matches()) {
            return new DigitMapStatement(matcher.group(1), matcher.group(2));
        }

        matcher = PRICE_MAP.matcher(input);
        if (matcher.matches()) {
            return new PriceStatement(matcher.group(1), matcher.group(3), matcher.group(4), matcher.group(5));
        }

        matcher = DIGIT_MAP_REQ.matcher(input);
        if (matcher.matches()) {
            return new ExchangeStatement(matcher.group(1));
        }

        matcher = PRICE_MAP_REQ.matcher(input);
        if (matcher.matches()) {
            return new ExchangeStatement(matcher.group(1), matcher.group(3));
        }

        matcher = GALAXY_EXH_REQ.matcher(input);
        if(matcher.matches()) {
            return new GalaxyExchangeStatement(matcher.group(2), matcher.group(4), matcher.group(1));
        }

        return new InvalidStatement();


    }

}
