package racingcar.domain.car;

public class Car {
    private int position = 0;
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(MovingAction movingAction) {
        if (movingAction.getAction() == CarAction.FORWARD) position++;
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name.toString(), this.position);
    }
}
