package racing.domain;

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

    public void initialize(String input) {
        for (String carName : input.split(",")){
            cars.add(new Car(carName));
        }
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerNamesWithSamePosition(cars.getMaxPosition());
    }

    public void play() {
        cars.play();
    }

    public Map<String, Integer> getStatus() {
        return cars.getStatus();
    }
}
