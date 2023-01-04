package racingcar.domain;

public enum Threshold {
    NORMAL_THRESHOLD(4);

    private final int value;

    Threshold(final int number) {
        this.value = number;
    }

    public int getNumber() {
        return value;
    }
}
