package CarRacing.domain;

public class Car {
    private static final int DEFAULT_POSITION = 1;
    private static final int CAR_SPEED = 1;
    private final CarName carName;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.position = position;
        this.carName = new CarName(name);
    }

    public void moveCar(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position += CAR_SPEED;
        }
    }

    public void carEvent() {
        moveCar(new RandomValueMovingStrategy(new RandomNumberGenerator()));
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == position;
    }

    public int getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
