package racingcar;

public class Car {

    private String name;
    private int position;

    public Car(String carName) {
        name = carName;
        position = 1;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position += 1;
        }
    }

    public boolean isSameName(String carName) {
        return name.equals(carName);
    }

    public boolean isSamePosition(Car other) {
        return position == other.position;
    }

    public int comparePosition(Car other) {
        return position - other.position;
    }

    public CarDto toDto() {
        return new CarDto(name, position);
    }

}
