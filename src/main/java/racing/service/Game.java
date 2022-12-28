package racing.service;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarName;
import racing.domain.Cars;

public class Game {
    private static final String CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 이름이 중복될 수 없습니다.";
    private final Cars cars;

    public Game(final List<String> rawCarNames) {
        validateUniqueness(rawCarNames);
        List<CarName> carNames = rawCarNames.stream()
                .map(CarName::new)
                .collect(Collectors.toList());
        cars = new Cars(carNames);
    }

    private void validateUniqueness(List<String> rawCarNames) {
        int distinctNameCount = rawCarNames.stream()
                .map(String::trim)
                .collect(Collectors.toSet())
                .size();
        if (distinctNameCount != rawCarNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
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
