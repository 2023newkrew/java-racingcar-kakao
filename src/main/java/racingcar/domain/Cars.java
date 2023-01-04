package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition();

        return getCarsByPosition(maxPosition);
    }

    private List<Car> getCarsByPosition(int position) {
        return cars.stream()
                .filter(car -> position == car.getPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void moveAll(MovingStrategy movingStrategy) {
        this.cars.forEach(car -> car.move(movingStrategy));
    }

    public List<Car> getList() {
        return this.cars;
    }
}
