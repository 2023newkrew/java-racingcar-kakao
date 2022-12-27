package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Game {
    private final Cars cars;
    public Game() {
        this.cars = new Cars();
    }

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void initialize(String[] carNames) {
        Arrays.stream(carNames)
            .forEach(carName -> cars.add(new Car(carName)));
    }

    public List<String> getWinnerNames() {
        return cars.getNamesWithSamePosition(cars.getMaxPosition());
    }

    public Map<String, Integer> playTurn() {
        cars.playTurn();
        return cars.getStatus();
    }
}
