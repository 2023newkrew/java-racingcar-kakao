package racingcar.domain;

public class Car {

    private final String carName;
    private int position;

    public static final int CAR_NAME_LENGTH_LIMIT = 5;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 " + CAR_NAME_LENGTH_LIMIT + "자 이하여야 합니다.");
        }
    }

    public void move(boolean bit) {
        if (bit ) {
            this.position++;
        }
    }

    public boolean isAt(int position) {
        return this.position == position;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
