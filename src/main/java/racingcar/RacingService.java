package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
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
}
