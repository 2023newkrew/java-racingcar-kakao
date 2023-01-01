package stringCalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final static String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";
    private final static int CUSTOM_DELIMITER_INDEX = 1;
    private final static int CUSTOM_INPUTSTRING_INDEX = 2;

    private String delimiterRegEx = ",|:";
    private String inputString;
    private Pattern pattern;

    public Delimiter(String inputString) {
        pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        Matcher matcher = pattern.matcher(inputString);
        this.inputString = inputString;
        if (matcher.find()) {
            delimiterRegEx += "|" + matcher.group(CUSTOM_DELIMITER_INDEX);
            this.inputString = matcher.group(CUSTOM_INPUTSTRING_INDEX);
        }
    }

    public String getDelimiterRegEx() {
        return delimiterRegEx;
    }

    public String getInputString() {
        return inputString;
    }

}
