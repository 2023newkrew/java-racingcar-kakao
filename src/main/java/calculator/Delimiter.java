package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private final String input;
    private String delimiter;

    public Delimiter(String input) {
        this.input = input;
        this.delimiter = ",|:";
    }

    public boolean hasCustomMatch() {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.input);
        return m.find();
    }

    public void checkCustomDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.input);
        if (m.find()) {
            this.delimiter = m.group(1);
        }
    }

    public String getDelimiter() {
        return this.delimiter;
    }
}
