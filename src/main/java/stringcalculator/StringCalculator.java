package stringcalculator;

import java.util.Objects;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String CUSTOM_DELIMITER_REGEX = "//([^0-9])\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    private Set<String> delimiters;

    public StringCalculator(Set<String> baseDelimiters) {
        delimiters = baseDelimiters;
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

        PositiveIntegerList positiveIntegerList = new PositiveIntegerList(splitByDelimiter(str));
        return positiveIntegerList.calculateSum();
    }

    private boolean registerDelimiterIfNotExist(String input) {
        Matcher m = pattern.matcher(input);

        if (m.find()) {
            delimiters.add(m.group(1));
            return true;
        }

        return false;
    }

    private String parseNumberContainingString(String input) {
        Matcher m = pattern.matcher(input);

        m.find();
        return m.group(2);
    }

    public String[] splitByDelimiter(String input) {
        return input.split(delimiterToString());
    }

    private String delimiterToString() {
        return String.join("|", delimiters);
    }

    public boolean hasCustomDelimiters() {
        return delimiters.size() > 2;
    }
}
