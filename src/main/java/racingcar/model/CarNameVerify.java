package racingcar.model;

public class CarNameVerify {
    private static final int MAX_NAME_LIMIT = 5;

    public static void verifyCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("There should be at least 1 character for car name");
        }

        if (name.length() > MAX_NAME_LIMIT) {
            throw new IllegalArgumentException("Car name should be MAX_NAME_LIMIT or under");
        }
    }
}
