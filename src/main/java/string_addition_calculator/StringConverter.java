package string_addition_calculator;

public class StringConverter {
    public static int convertString(String input) {
        if (input.length() == 0) {
            return 0;
        }
         return convertStringToInteger(input);
    }

    private static int convertStringToInteger(String input) {
        try {
           return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
        }
    }
}
