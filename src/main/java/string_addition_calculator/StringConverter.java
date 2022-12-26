package string_addition_calculator;

public class StringConverter {
    private int result;

    public void convertString(String s) {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 변환할 수 없는 문자열입니다.");
        }
         this.result = result;
    }

    public int getResult() {
        return this.result;
    }
}
