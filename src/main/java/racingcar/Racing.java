package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int count;

    public Racing(int count) {
        this.count = count;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarList() {
        return cars;
    }

    public void doStep() {
        cars.forEach(Car::forward);
        count--;
    }

    public int getCount() {
        return count;
    }

    public boolean isFinished() {
        return count == 0;
    }

    public List<String> winner() {
        int maxDist = 0;
        for(Car car : cars)
            maxDist = Math.max(maxDist, car.getDistance());

        List<String> result = new ArrayList<>();
        final int finalMaxDist = maxDist;
        Stream<Car> filtered = cars.stream().filter(car ->  car.getDistance() == finalMaxDist);
        filtered.forEach(car -> {result.add(car.getName());});
        return result;
    }
}
