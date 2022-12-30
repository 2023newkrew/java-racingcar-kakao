package racingcar.domain.collection;

import racingcar.domain.car.RacingCar;
import racingcar.domain.dto.RacingCarDto;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarCollection {
    private final List<RacingCar> cars;

    public RacingCarCollection(List<RacingCar> cars) {
        this.cars = cars;
        validateNotEmptyOrNull();
        validateNotDuplicates();
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public void moveAll() {
        cars.forEach(RacingCar::move);
    }

    public List<RacingCarDto> selectWinners() {
        return getCarsWithMaxPosition().stream()
                .map(RacingCarDto::toDto)
                .collect(Collectors.toList());
    }

    private List<RacingCar> getCarsWithMaxPosition() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getCarPosition)
                .max()
                .getAsInt();
        return cars.stream()
                .filter(e -> e.getCarPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private void validateNotEmptyOrNull() {
        if (cars == null || cars.isEmpty()) {
            throw new BusinessException(ErrorCode.EMPTY_CAR_LIST_EXCEPTION);
        }
    }

    private void validateNotDuplicates() {
        long distinctCount = cars.stream()
                .distinct()
                .count();
        if (distinctCount < cars.size()) {
            throw new BusinessException(ErrorCode.DUPLICATE_CAR_NAME_EXCEPTION);
        }
    }
}
