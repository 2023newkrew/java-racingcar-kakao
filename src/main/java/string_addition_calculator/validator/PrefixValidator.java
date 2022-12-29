package string_addition_calculator.validator;

public class PrefixValidator {
    public void validate(String input) {
        if (input.length() == 0) {
            return;
        }
        if (Character.isDigit(input.charAt(0))) {
            return;
        }
        if (isCustomDelimiterFormat(input)) {
            return;
        }
        throw new IllegalArgumentException("양식에 알맞게 입력해주세요.");
    }

    private boolean isCustomDelimiterFormat(String input) {
        return input.length() > 5 && input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\n';
    }
}
