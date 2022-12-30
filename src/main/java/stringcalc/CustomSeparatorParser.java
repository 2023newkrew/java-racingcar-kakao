package stringcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {

    private static final Pattern pattern = Pattern.compile("//(.*)\\n(.*)");

    public static String parseToCustomSeparator(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            validateSeparatorLength(customDelimiter);
            return customDelimiter;
        }
        return null;
    }

    private static void validateSeparatorLength(String separator){
        if (separator.length() != 1) {
            throw new RuntimeException();
        }
    }

}
