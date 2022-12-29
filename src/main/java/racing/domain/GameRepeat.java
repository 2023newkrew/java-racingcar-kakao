package racing.domain;

public class GameRepeat {
    private static final int MIN_REPEAT = 1;
    private static final int MAX_REPEAT = 100;
    private static final String NOT_ENOUGH_REPEAT_EXCEPTION_MESSAGE = "[ERROR] 최소 1회는 시도해야 합니다.";
    private static final String TOO_MANY_REPEAT_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 최대 100회까지만 가능합니다.";

    private int remaining;

    public GameRepeat(int repeat) {
        validate(repeat);
        this.remaining = repeat;
    }

    public void validate(int repeat) {
        if (repeat < MIN_REPEAT) {
            throw new IllegalArgumentException(NOT_ENOUGH_REPEAT_EXCEPTION_MESSAGE);
        }
        if (repeat > MAX_REPEAT) {
            throw new IllegalArgumentException(TOO_MANY_REPEAT_EXCEPTION_MESSAGE);
        }
    }

    public void reduce() {
        remaining--;
    }

    public boolean hasRemaining() {
        return remaining > 0;
    }
}
