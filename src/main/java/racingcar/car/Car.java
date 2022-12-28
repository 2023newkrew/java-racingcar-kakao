package racingcar.car;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(CarAction carAction) {
        if (carAction == CarAction.FORWARD) position++;
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }
}
