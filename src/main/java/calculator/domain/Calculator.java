package calculator.domain;

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
        String[] stringNumbers = prompt.getStringNumbers();
        int ret = 0;
        for (String stringNumber : stringNumbers) {
            ret += parseIntOnlyPositiveStringNumber(stringNumber);
        }
        return ret;
    }

    public int parseIntOnlyPositiveStringNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_EXCEPTION);
        }
        return number;
    }
}
