package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String defaultDelimiter = ",|;";

    private static final String customDelimitingRegex = "//(.+)\n(.*)";


    public String[] split(String input) {
        return input.split(defaultDelimiter);
    }

    public String[] split(String input, String customDelimiter) {
        return input.split(defaultDelimiter + "|" + customDelimiter);
    }

    public int parseInt(String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < 0) {
            throw new RuntimeException();
        }
        return parsedNumber;
    }

    public String[] toStringArray(String inputstring) {
        Matcher m = Pattern.compile(customDelimitingRegex)
                .matcher(inputstring);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return split(m.group(2), customDelimiter);
        }
        return split(inputstring);
    }
}
