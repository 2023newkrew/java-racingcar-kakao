package racingcar.car;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 0;

    private int position = 0;
    private final String name;

    public Car(String name) {
        if (!isValidName(name)) throw new IllegalArgumentException("Invalid Name");

        this.name = name;
    }

    public static boolean isValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() <= MIN_NAME_LENGTH) {
            return false;
        }
        return !name.contains(" ");
    }

    public void move(CarAction carAction) {
        if (carAction == CarAction.FORWARD) position++;
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }
}
