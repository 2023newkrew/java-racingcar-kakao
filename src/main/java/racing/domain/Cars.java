package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

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

    public int getMaxPosition() {
        return Collections.max(cars, Comparator.comparing(Car::getPosition))
                .getPosition();
    }

    public List<String> getNamesWithSamePosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
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

    public boolean isMovable() {
        return generateRandomNumber(RANDOM_BOUND) >= THRESHOLD;
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.getName(), car.getPosition()));
        return status;
    }
}
