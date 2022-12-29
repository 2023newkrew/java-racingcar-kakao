package racing.domain.car;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static racing.util.RandomNumberGenerator.generateRandomNumber;

public class Cars {
    private final List<Car> cars;

    private static final int THRESHOLD = 4;
    private static final int RANDOM_BOUND = 10;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }


    public void add(Car car) {
        cars.add(car);
    }

    public Car getCarWithMaxPosition() {
        return max(cars);
    }

    public List<String> getNamesWithSamePosition(Car car) {
        return cars.stream()
                .filter(car::isEqualPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void playTurn() {
        cars.forEach(this::movePositionIfMovable);
    }

    private void movePositionIfMovable(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    public boolean isMovable(int input) {
        return input >= THRESHOLD;
    }

    public boolean isMovable() {
        return isMovable(generateRandomNumber(RANDOM_BOUND));
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.getName(), car.getPosition()));
        return status;
    }
}
