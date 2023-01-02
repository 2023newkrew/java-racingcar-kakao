package racingcar.models;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public final List<Car> winners;

    public Winner(List<Car> cars) {
        this.winners = findWinners(cars);
    }

    private List<Car> findWinners(List<Car> cars) {
        return cars.stream().filter((car) -> car.throughSpecificPoint(getMaxPosition(cars)))
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<String> getWinnerNames() {
        return winners.stream().map(Car::getName).collect(Collectors.toList());
    }
}
