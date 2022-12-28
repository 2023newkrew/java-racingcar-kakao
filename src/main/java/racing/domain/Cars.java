package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.max;


public class Cars {

    private final List<Car> cars;

    private static final int THRESHOLD = 4;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isMove(int number) {
        return number >= THRESHOLD;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinnerNamesWithSamePosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void play() {
        for (Car car : cars) {
            increasePositionIfMovable(car);
        }
    }

    private void increasePositionIfMovable(Car car) {
        if(isMove(RandomNumberGenerator.generateRandomNumber())) {
            car.move();
        }
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> status = new HashMap<>();
        for (Car car : cars) {
            status.put(car.getName(), car.getPosition());
        }
        return status;
    }
}
