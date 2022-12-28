package stringcalculator;

import java.util.Objects;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private Set<String> delimiters;

    public StringCalculator(Set<String> baseDelimiters) {
        delimiters = baseDelimiters;
    }

    public int run(String input) {
        if (Objects.isNull(input) || input.length() <= 1) {
            return handleStringLengthShorterThanTwo(input);
        }

        return calculate(input);
    }

    private int calculate(String input) {
        String str = input;
        if (registerDelimiterIfNotExist(input)) {
            str = parseNumberContainingString(input);
        }

        PositiveIntegerList positiveIntegerList = new PositiveIntegerList(splitByDelimiter(str));
        positiveIntegerList.validate();
        return positiveIntegerList.calculateSum();
    }

    public int handleStringLengthShorterThanTwo(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(input);
    }

    public boolean registerDelimiterIfNotExist(String input) {
        Matcher m = Pattern.compile("//([^0-9])\n(.*)").matcher(input);

        if (m.find()) {
            delimiters.add(m.group(1));
            return true;
        }

        return false;
    }

    public String parseNumberContainingString(String input) {
        Matcher m = Pattern.compile("//([^0-9])\n(.*)").matcher(input);

        if (m.find()) {
            return m.group(2);
        }

        return null;
    }

    public String[] splitByDelimiter(String input) {
        return input.split(delimiterToString());
    }

    public String delimiterToString() {
        return String.join("|", delimiters);
    }

    public boolean hasCustomDelimiters() {
        return delimiters.size() > 2;
    }
}
