package string_addition_calculator;

public class StringConverter {
    private int result;

    public void convertString(String input) {
        if (input.length() == 0) {
            this.result = 0;
            return;
        }
         this.result = convertStringToInteger(input);
    }

    private int convertStringToInteger(String input) {
        try {
           return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
        }
    }

    public int getResult() {
        return this.result;
    }
}
