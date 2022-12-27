package string_calculator.model;

import java.util.Arrays;

public class Validator {

    public static boolean validate(String[] numbers) throws RuntimeException {
        return Arrays.stream(numbers).filter(number -> {
            int converted = convertToNumber(number);
            return validatePositive(converted);
        }).count() == numbers.length;
    }

    private static int convertToNumber(String element) throws RuntimeException {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닙니다.");
        }
    }

    private static boolean validatePositive(int number) throws RuntimeException {
        if (number < 0){
            throw new RuntimeException("숫자가 음수입니다.");
        }
        return true;
    }
}
