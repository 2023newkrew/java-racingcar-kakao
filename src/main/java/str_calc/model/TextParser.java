package str_calc.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final String REGEX_DELIMITER = "//(.)\n(.*)";
    private final List<String> delimiters;

    public TextParser() {
        this.delimiters = new ArrayList<>(TextParser.DEFAULT_DELIMITERS);
    }

    private void addDelimiter(String delimiter) {
        this.delimiters.add(delimiter);
    }

    private String separateTextFromDelimiter(String text) {
        Matcher m = Pattern.compile(TextParser.REGEX_DELIMITER).matcher(text);
        if (m.find()) {
            this.addDelimiter(m.group(1));
            return m.group(2);
        }
        return text;
    }

    public List<String> splitText(String text) {
        text = this.separateTextFromDelimiter(text);
        return Arrays.asList(text.split(String.join("|", this.delimiters)));
    }
}
