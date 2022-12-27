package racingcar.car;

public class Car {

    private int position;
    private final String name;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public void move(CarAction carAction) {
        if (carAction == CarAction.FORWARD) {
            position++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }
}
