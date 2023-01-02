package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"; // (.): 사용자 정의 구분자 (.*): 구분자로 나눌 문자열
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int PURIFIED_INPUT_INDEX = 2;
    private final String delimiter;
    private final boolean hasCustomDelimiter;
    private final String processedInput;

    public DelimiterParser(String pureInput, List<String> defaultDelimiters) {

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(pureInput);
        if (matcher.find()) {
            this.hasCustomDelimiter = true;
            this.delimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            this.processedInput = matcher.group(PURIFIED_INPUT_INDEX);
            return;
        }
        this.hasCustomDelimiter = false;
        this.delimiter = String.join("|", defaultDelimiters);
        this.processedInput = pureInput;
    }


    public boolean hasCustomDelimiter() {
        return this.hasCustomDelimiter;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getProcessedInput() {
        return this.processedInput;
    }
}
