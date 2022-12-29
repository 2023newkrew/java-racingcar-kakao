package racingcar.domain;

import java.util.List;

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

    public boolean isNotFinished() {
        return count != 0;
    }

    public List<String> winner() {
        return cars.winner();
    }
}
