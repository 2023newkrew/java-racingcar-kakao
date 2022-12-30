package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final List<Car> cars;

    public Cars(final List<CarName> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
        }
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
