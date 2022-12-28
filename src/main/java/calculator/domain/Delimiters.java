package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;
import static calculator.constant.MessageConstant.DELIMITER_LENGTH_EXCEPTION;
import static java.lang.Character.isDigit;

public class Delimiters {
    private final List<Delimiter> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(Arrays.asList(new Delimiter(":"), new Delimiter(",")));
    }

    public void add(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public String getRegex() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        delimiters.forEach(sb::append);
        sb.append(']');
        return sb.toString();
    }
}
