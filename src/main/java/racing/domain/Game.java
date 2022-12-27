package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Game {
    private Cars cars;

    public Game() {
        this.cars = new Cars();
    }

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void initialize(String input) {
        String[] carNames = input.split(",");
        Arrays.stream(carNames)
            .forEach(carName -> {
                cars.add(new Car(carName));
        });
    }

    public List<String> decideWinners() {
        return cars.getWinnerNamesWithSamePosition(cars.getMaxPosition());
    }

    public void play() {
        cars.play();
    }

    public Map<String, Integer> getStatus() {
        return cars.getStatus();
    }
}
