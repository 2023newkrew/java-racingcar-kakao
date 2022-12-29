package calculator;

import java.util.List;

public class Validator {
    public void nonNegativeOrThrow(List<Integer> numbers){
        boolean hasNegative = numbers.stream().anyMatch(n -> n < 0);
        if (hasNegative) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
    }

    public boolean isOneNumber(String expression) {
        try {
            Integer.parseInt(expression);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
