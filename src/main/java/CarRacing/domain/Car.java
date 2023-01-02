package CarRacing.domain;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private static final int CAR_SPEED = 1;
    private final CarName carName;
    private CarPosition position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.position = new CarPosition(position);
        this.carName = new CarName(name);
    }

    public void moveCar(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move(CAR_SPEED);
        }
    }

    public void carEvent() {
        moveCar(new RandomValueMovingStrategy(new RandomNumberGenerator()));
    }

    public CarPosition getMaxPosition(CarPosition maxPosition) {
        return position.largerPosition(maxPosition);
    }

    public boolean isWinner(CarPosition maxPosition) {
        return position.equals(maxPosition);
    }

    public CarPosition getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
