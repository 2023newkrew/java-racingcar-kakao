package racing.utils;

public class InputValidator {
    private static final String INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 정수여야 합니다.";
    private static final String INPUT_REPEAT_RANGE_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 양수여야 합니다.";

    public int validateGameRepeat(String inputRepeat) {
        int repeat;
        try {
            repeat = Integer.parseInt(inputRepeat);
            validatePositive(repeat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_REPEAT_FORMAT_EXCEPTION_MESSAGE);
        }
        return repeat;
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(INPUT_REPEAT_RANGE_EXCEPTION_MESSAGE);
        }
    }
}
