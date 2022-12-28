package racing.service;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarName;
import racing.domain.Cars;

public class Game {
    private final Cars cars;

    public Game(final List<String> rawCarNames) {
        validateUniqueness(rawCarNames);
        List<CarName> carNames = rawCarNames.stream().map(CarName::new).collect(Collectors.toList());
        cars = new Cars(carNames);
    }

    private void validateUniqueness(List<String> rawCarNames) {

    }

    public void play() {
        cars.play();
    }

    public List<String> getStatus() {
        return cars.getStatus();
    }

    public List<CarName> getWinners() {
        return cars.getWinners();
    }


}
