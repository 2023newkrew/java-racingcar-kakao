package calculator.domain;

import java.util.Arrays;

import static calculator.constant.MessageConstant.INVALID_INPUT_EXCEPTION;
import static calculator.constant.MessageConstant.NEGATIVE_NUMBER_EXCEPTION;

public class Calculator {
    public int calculate(Prompt prompt) {
        if(prompt.isEmptyInput()) {
            return 0;
        }
        prompt.changePromptIfExistCustomDelimiter();
        return calculateWithDelimiter(prompt);
    }

    private int calculateWithDelimiter(Prompt prompt) {
        String[] stringNumbers = prompt.getParsedStringNumbers();
        return Arrays.stream(stringNumbers)
                .mapToInt(this::parseIntOnlyPositiveStringNumber)
                .sum();
    }

    public int parseIntOnlyPositiveStringNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            if (number < 0) {
                throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException(INVALID_INPUT_EXCEPTION);
        }
    }
}
