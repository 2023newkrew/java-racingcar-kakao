package calculator.domain;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;

public class Delimiter {

    private final char delimiter;

    public Delimiter(char delimiter) {
        if (Character.isDigit(delimiter)) {
            throw new IllegalArgumentException(DELIMITER_FORMAT_EXCEPTION);
        }
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }
}
