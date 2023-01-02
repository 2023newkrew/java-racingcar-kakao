package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCarsInPosition(int position) {
        return cars.stream()
                .filter(p -> Objects.equals(p.getPosition(), position))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return new ArrayList<>(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.proceedNextTurn(GameRule.isAbleToProceed());
        }
    }
}
