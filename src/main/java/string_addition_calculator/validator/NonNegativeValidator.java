package string_addition_calculator.validator;

public class NonNegativeValidator {
    public void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0 이상의 정수만 허용합니다.");
        }
    }
}
