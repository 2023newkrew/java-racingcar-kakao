package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String REGEX = "//(.)\n(.*)"; // (.): 사용자 정의 구분자 (.*): 구분자로 나눌 문자열
    private final String delimiter;
    private final boolean hasCustomDelimiter;
    private final String processedInput;

    public DelimiterParser(String pureInput, List<String> defaultDelimiters) {

        Matcher matcher = Pattern.compile(REGEX).matcher(pureInput);
        if (matcher.find()) {
            this.hasCustomDelimiter = true;
            this.delimiter = matcher.group(1);
            this.processedInput = matcher.group(2);
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
