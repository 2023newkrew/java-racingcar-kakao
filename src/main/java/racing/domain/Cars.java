package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.dto.CarDTO;

public class Cars {
    private static final String NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final List<Car> cars;

    public Cars(final List<CarName> carNames) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<CarDTO> getCarDtoList() {
        return cars.stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
    }

    public List<CarName> getWinners(Comparator<CarDTO> comparator) {
        List<CarDTO> carDtoList = getCarDtoList();
        carDtoList.sort(comparator);
        CarDTO lastWinner = carDtoList.get(cars.size() - 1);
        List<CarName> winners = carDtoList.stream()
                .filter(car -> comparator.compare(lastWinner, car) == 0)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
        return winners;
    }
}
