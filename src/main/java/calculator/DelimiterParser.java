package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private final Matcher matcher;
    private String delimiter;
    private String purifiedInput;

    public DelimiterParser(String numbersStr, List<String> defaultDelimiters) {
        this.delimiter = String.join("|",defaultDelimiters);
        this.matcher = Pattern.compile("//(.)\n(.*)").matcher(numbersStr);
        this.purifiedInput = numbersStr;
    }

    public boolean hasCustomMatch() {
        // java.util.regex 패키지의 Matcher, Pattern import
        return this.matcher.find();
    }

    public void checkCustomDelimiter() {
        if (this.matcher.find()) {
            this.delimiter = this.matcher.group(1);
            this.purifiedInput = this.matcher.group(2);
        }
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getPurifiedInput() {
        return purifiedInput;
    }
}
