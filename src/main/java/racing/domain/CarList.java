package racing.domain;

import java.util.Arrays;

public class CarList {

    private Car[] cars;

    public CarList(String names) {
        cars = Arrays.stream(names.split(","))
                .map(name -> new Car(name))
                .toArray(Car[]::new);
    }

    public CarList(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public int getLength() {
        return cars.length;
    }

}
