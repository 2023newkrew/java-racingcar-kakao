package racingcar.model;

public class CarName {
    private static final int LENGTH_LIMIT = 5;
    private String name;

    public CarName(String name) {
        if (CarName.isInvalidName(name)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이내여야 합니다");
        }
        this.name = name;
    }

    private static boolean isInvalidName(String name) {
        return name.isEmpty() || name.length() > LENGTH_LIMIT;
    }

    public String get() {
        return this.name;
    }
}
