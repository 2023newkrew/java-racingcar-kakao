package racing.service;

import java.util.List;
import racing.domain.Cars;

public class Game {
    private final Cars cars;

    public Game(final List<String> carNames) {
        cars = new Cars(carNames);
    }

    public void play() {
        cars.play();
    }

    public List<String> getStatus() {
        return cars.getStatus();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }


}
