package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private static final Comparator<Car> DEFAULT_CAR_COMPARATOR = new CarDistanceComparator();

    private final List<Car> cars;

    public Cars(List<?> args) {
        if (args == null || args.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
        }
        if (args.stream().allMatch(car -> car instanceof CarName)) {
            args = convertNamesToCars((List<CarName>) args);
        }
        this.cars = (List<Car>) args;
    }

    private List<Car> convertNamesToCars(List<CarName> carNames) {
        return carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarName> getWinners() {
        return getWinners(DEFAULT_CAR_COMPARATOR);
    }

    public List<CarName> getWinners(Comparator<Car> comparator) {
        Car lastWinner = getLastWinner(comparator);
        return cars.stream()
                .filter(car -> comparator.compare(lastWinner, car) == 0)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private Car getLastWinner(Comparator<Car> comparator) {
        return cars.stream().max(comparator).orElseThrow();
    }
}
