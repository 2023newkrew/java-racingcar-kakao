package racingcar.domain;

public enum Threshold {
    NORMAL_THRESHOLD(4);

    private final int number;

    Threshold(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
