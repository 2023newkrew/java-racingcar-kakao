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

    // TODO: private으로 해도 될 것 같은데? 근데 테스트가 안돌아감.
    public boolean isValidNumber(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        if (number<0) {
            return false;
        }
        return true;
    }

    private void validateInput(String s) {
        if (!isValidNumber(s)) {
            throw new RuntimeException();
        }
    }


}
