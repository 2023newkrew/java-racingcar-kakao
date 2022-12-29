package numberCalculator;

import java.util.regex.Pattern;

public class SeparatorParser {
    public static final String DEFAULT_STRING_SEPARATOR = ",|:";

    public String extract(String input) {
        if (isIncludingSeparator(input)) {
            return Pattern.quote(input.substring(input.indexOf("//") + 2, input.indexOf("\n")));
        }
        return DEFAULT_STRING_SEPARATOR;
    }

    private boolean isIncludingSeparator(String input) {
        return input.matches("^//(.*)\\n(.*)");
    }
}