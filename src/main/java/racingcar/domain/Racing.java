package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class Racing {
    private Cars cars;
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void addCars(List<Car> names) {
        this.cars = new Cars(names);
    }

    public List<Car> getCarList() {
        return cars.toList();
    }

    public void tryForward() {
        cars.tryForward();
        count--;
    }

    public int getCount() {
        return count;
    }

    public boolean isFinished() {
        return count == 0;
    }

    public List<String> winner() {
        return cars.winner();
    }
}
