package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Validator;

public class RacingService {

    private static final int THRESHOLD = 4;

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public CarAction getActionResult(int num) {
        if (num < THRESHOLD) {
            return CarAction.STAY;
        }

        return CarAction.FORWARD;
    }

    public int validateTurn(String turnInput) throws IllegalArgumentException {
        if (!Validator.isValidTurn(turnInput)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(turnInput);
    }
}
