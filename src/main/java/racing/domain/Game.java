package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Game {
    private final Cars cars;
    public Game(List<String> carNames) {
        this.cars = new Cars(carNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList()));
    }

    public Game(Cars cars) {
        this.cars = cars;
    }

    public List<String> getWinnerNames() {
        return cars.getNamesWithSamePosition(cars.getMaxPosition());
    }

    public Map<String, Integer> playTurn() {
        cars.playTurn();
        return cars.getStatus();
    }
}
