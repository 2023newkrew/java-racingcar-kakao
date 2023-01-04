package stringcalculator.domain;

import java.util.Objects;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private Splitter splitter;

    public StringCalculator(List<String> baseDelimiters) {
        splitter = new Splitter(baseDelimiters);
    }

    public int run(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            return 0;
        }

        return calculate(input);
    }

    private int calculate(String input) {
        String str = input;
        if (registerDelimiterIfNotExist(input)) {
            str = parseNumberContainingString(input);
        }

        return new PositiveIntegerList(splitter.splitByDelimiters(str)).calculateSum();
    }

    private boolean registerDelimiterIfNotExist(String input) {
        Matcher m = pattern.matcher(input);

        if (m.find()) {
            splitter.addDelimiter(m.group(1));
            return true;
        }

        return false;
    }

    private String parseNumberContainingString(String input) {
        Matcher m = pattern.matcher(input);

        m.find();
        return m.group(2);
    }

}
