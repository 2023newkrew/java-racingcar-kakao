package racingcar.racing;

import racingcar.car.CarAction;
import racingcar.car.CarDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public CarAction getActionResult(int no) {
        if (no < THRESHOLD) return CarAction.STAY;

        return CarAction.FORWARD;
    }
}
