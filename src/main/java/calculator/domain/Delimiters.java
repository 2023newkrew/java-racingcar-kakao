package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;
import static calculator.constant.MessageConstant.DELIMITER_LENGTH_EXCEPTION;
import static java.lang.Character.isDigit;

public class Delimiters {
    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(Arrays.asList(":", ","));
    }

    public void add(String delimiter) {
        validateDelimiter(delimiter);
        delimiters.add(delimiter);
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.length() > 1) {
            throw new RuntimeException(DELIMITER_LENGTH_EXCEPTION);
        }
        if (isDigit(delimiter.charAt(0))) {
            throw new RuntimeException(DELIMITER_FORMAT_EXCEPTION);
        }
    }

    public String getRegex() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        delimiters.forEach(sb::append);
        sb.append(']');
        return sb.toString();
    }
}
