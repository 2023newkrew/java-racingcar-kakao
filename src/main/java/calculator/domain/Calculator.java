package calculator.domain;

import static calculator.constant.MessageConstant.NEGATIVE_NUMBER_EXCEPTION;

import java.util.Arrays;

public class Calculator {
    public int calculate(Prompt prompt) {
        if(prompt.isEmptyInput()) {
            return 0;
        }
        prompt.changePromptIfExistCustomDelimiter();
        return calculateWithDelimiter(prompt);
    }

    private int calculateWithDelimiter(Prompt prompt) {
        return Arrays.stream(prompt.getStringNumbers())
                .mapToInt(this::parseIntOnlyPositiveStringNumber)
                .sum();
    }

    private int parseIntOnlyPositiveStringNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            if (number < 0) {
                throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
