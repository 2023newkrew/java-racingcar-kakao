package calculator.domain.calculator;

import calculator.domain.calculator.prompt.Prompt;

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
        return Arrays.stream(prompt.getParsedStringNumbers())
                .mapToInt(this::parseIntOnlyPositiveStringNumber)
                .sum();
    }

    private int parseIntOnlyPositiveStringNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION);
        }
        return number;
    }
}
