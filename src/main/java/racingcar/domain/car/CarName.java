package racingcar.domain.car;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 0;

    private final String name;

    CarName(String name) {
        if (!isValidName(name)) throw new IllegalArgumentException("Invalid Name");
        this.name = name;
    }

    public static boolean isValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() <= MIN_NAME_LENGTH) {
            return false;
        }
        return !name.contains(" ");
    }

    @Override
    public String toString() {
        return name;
    }
}
