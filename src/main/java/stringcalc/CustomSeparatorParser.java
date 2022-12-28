package stringcalc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorParser {

    public String parse(String input) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(input);
        if (m.find()) {
            String customSeparator = m.group(1);
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
