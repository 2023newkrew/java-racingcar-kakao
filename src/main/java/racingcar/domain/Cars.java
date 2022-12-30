package racingcar.domain;

import racingcar.factory.CarFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public int getMaxPosition(){
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition)).orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}
