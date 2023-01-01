package CarRacing.domain;

public class Car {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int DEFAULT_POSITION = 1;
    private static final int CAR_SPEED = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        validateName(name);
        this.position = position;
        this.name = name;
    }

    public void validateName(String name) {
        if (name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 다섯 글자 이하여야 합니다.");
        }
        if (name.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 한 글자 이상이어야 합니다.");
        }
    }

    public void moveCar(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position += CAR_SPEED;
        }
    }

    public void carEvent() {
        moveCar(new RandomValueMovingStrategy());
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, position);
    }

    public String getWinnerName(int maxPosition) {
        if (maxPosition == position) {
            return name;
        }
        return null;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
