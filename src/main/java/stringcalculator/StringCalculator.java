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

    public int play(String input) {
        if (!Objects.isNull(input) && input.length() == 1) {
            return Integer.parseInt(input);
        }

        return 0;
    }

    public void registerDelimiterIfNotExist(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            delimiters.add(m.group(1));
        }
    }

    public String parseNumbuerContainingString(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

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

    public Set<String> getDelimiters() {
        return delimiters;
    }
}
