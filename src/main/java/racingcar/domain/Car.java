package racingcar.domain;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String carName;
    private int position;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 최소 1자 이상이여야 합니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(int number) {
        if (number >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
