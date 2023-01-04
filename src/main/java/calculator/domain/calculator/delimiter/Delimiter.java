package calculator.domain.calculator.delimiter;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;
import static calculator.constant.MessageConstant.DELIMITER_LENGTH_EXCEPTION;
import static java.lang.Character.isDigit;

public class Delimiter {
    private static final int DELIMITER_LENGTH = 1;

    String delimiter;
    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.length() != DELIMITER_LENGTH) {
            throw new RuntimeException(DELIMITER_LENGTH_EXCEPTION);
        }
        if (isDigit(delimiter.charAt(0))) {
            throw new RuntimeException(DELIMITER_FORMAT_EXCEPTION);
        }
    }

    public void appendDelimiter(StringBuilder stringBuilder) {
        stringBuilder.append(delimiter);
    }
}
