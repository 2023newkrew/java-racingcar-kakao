package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {

    private static final String REGEX = "//(.)\n(.*)"; // (.): 사용자 정의 구분자 (.*): 구분자로 나눌 문자열
    private final String delimiter;
    private final boolean hasCustomDelimiter;
    private final String pureInput;
    private final String processedInput;

    public DelimiterParser(String pureInput, List<String> defaultDelimiters) {
        this.pureInput = pureInput;
        this.hasCustomDelimiter = judgeHasCustomDelimiter();
        this.delimiter = extractDelimiter(defaultDelimiters);
        this.processedInput = generateProcessedInput();
    }

    private Matcher generateMatcher() {
        return Pattern.compile(REGEX).matcher(pureInput);
    }

    private boolean judgeHasCustomDelimiter() {
        if (generateMatcher().find()) {
            return true;
        }
        return false;
    }

    private String extractDelimiter(List<String> defaultDelimiters) {
        if (hasCustomDelimiter()) {
            Matcher matcher = generateMatcher();
            matcher.find();
            return matcher.group(1);
        }
        return String.join("|", defaultDelimiters);
    }

    private String generateProcessedInput() {
        if (hasCustomDelimiter()) {
            Matcher matcher = generateMatcher();
            matcher.find();
            return matcher.group(2);
        }
        return pureInput;
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
