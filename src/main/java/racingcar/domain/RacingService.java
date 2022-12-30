package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDTO;
import racingcar.util.Validator;

public class RacingService {

    private static final int THRESHOLD = 4;

    public List<String> getWinners(List<CarDTO> cars) {
        int maxPosition = cars.stream()
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(CarDTO::getName)
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
