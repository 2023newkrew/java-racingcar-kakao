package calculator.domain.calculator.delimiter;

import static calculator.constant.MessageConstant.DELIMITER_FORMAT_EXCEPTION;
import static calculator.constant.MessageConstant.DELIMITER_LENGTH_EXCEPTION;
import static java.lang.Character.isDigit;

public class Delimiter {
    String delimiter;
    public Delimiter(String delimiter) {
        validateDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.length() != 1) {
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
