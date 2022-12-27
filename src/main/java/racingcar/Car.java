package racingcar;

public class Car {

    private final String carName;
    private int position;

    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public void stay() {
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }
}
