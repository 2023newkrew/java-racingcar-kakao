package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiters {
    private static final List<Delimiter> DEFAULT_DELIMITER = new ArrayList<>(Arrays.asList(new Delimiter(":"), new Delimiter(",")));
    private final List<Delimiter> delimiters;

    public Delimiters() {
        this.delimiters = DEFAULT_DELIMITER;
    }

    public void add(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public String getRegex() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        delimiters.forEach((delimiter)-> {
            delimiter.appendDelimiter(stringBuilder);
        });
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
