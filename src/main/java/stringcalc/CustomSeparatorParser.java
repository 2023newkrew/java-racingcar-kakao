package stringcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {

    private static final Pattern customSeparatorPattern = Pattern.compile("//(.*)\n(.*)");

    public String parse(String input) {
        Matcher matcher = customSeparatorPattern.matcher(input);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            validateSeparatorLength(customSeparator);
            return customSeparator;
        }
        return null;
    }

    private void validateSeparatorLength(String separator){
        if (separator.length() != 1) {
            throw new RuntimeException();
        }
    }

}
