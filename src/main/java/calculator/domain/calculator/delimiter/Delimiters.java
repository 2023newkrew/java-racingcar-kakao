package calculator.domain.calculator.delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiters {
    private final List<Delimiter> delimiters;

    private static final List<Delimiter> DEFAULT_DELIMITER = new ArrayList<>(Arrays.asList(new Delimiter(":"), new Delimiter(",")));

    public Delimiters() {
        this(new ArrayList<>(DEFAULT_DELIMITER));
    }

    public Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
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
