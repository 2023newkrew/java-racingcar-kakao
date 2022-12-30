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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) return false;

        Car cp = (Car) obj;

        return name.equals(cp.name) && position == cp.position;
    }
}
