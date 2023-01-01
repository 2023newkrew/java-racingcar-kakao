package stringCalculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {

    private final static String CUSTOM_DELIMITER_REGEX = "//(.)\\\\n(.*)";
    private final static Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);;
    private final static int CUSTOM_DELIMITER_INDEX = 1;
    private final static int CUSTOM_INPUTSTRING_INDEX = 2;

    private String delimiterRegEx = ",|:";
    private String inputString;

    public Delimiter(String inputString) {
        Matcher matcher = pattern.matcher(inputString);
        this.inputString = inputString;
        if (matcher.find()) {
            this.delimiterRegEx = matcher.group(CUSTOM_DELIMITER_INDEX);
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
