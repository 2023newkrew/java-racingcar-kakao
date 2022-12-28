package calculator;

public class SumHelper {
    private static final String OUTPUT_INVALID_INPUT = "유효하지 않은 문자열이 포함되었습니다.";
    private String[] data;

    public SumHelper() {
    }

    private SumHelper(String[] array) {
        this.data = array;
    }

    static SumHelper sumHelperForTest(String[] array) {
        return new SumHelper(array);
    }

    public int sum() {
        int result = 0;
        for (String input : data) {
            validateInput(input);
            int i = Integer.parseInt(input);
            result += i;
        }
        return result;
    }

    public boolean isValidNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return number>=0;
    }

    private void validateInput(String s) {
        if (!isValidNumber(s)) {
            throw new IllegalArgumentException(OUTPUT_INVALID_INPUT);
        }
    }
}
