package calculator;

public class SumHelper {
    String[] data;

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
            throw new IllegalArgumentException("유효하지 않은 문자열이 포함되었습니다.");
        }
    }
}
