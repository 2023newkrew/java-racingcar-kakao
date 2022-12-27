package racingcar;

public class Car {

    private String name;

    public Car(String carName) {
        name = carName;
    }

    public boolean isSameName(String carName) {
        return name.equals(carName);
    }

}
