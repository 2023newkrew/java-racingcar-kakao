package calculator.model;

import java.util.Arrays;

public class Validator {

    public static void validate(String[] numbers) throws RuntimeException {
        Arrays.stream(numbers).forEach(number -> {
            int converted = convertToNumber(number);
            validatePositive(converted);
        });
    }

    private static int convertToNumber(String element) throws RuntimeException {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static void validatePositive(int number) throws RuntimeException {
        if (number < 0) {
            throw new RuntimeException("숫자가 음수입니다.");
        }
    }
}
