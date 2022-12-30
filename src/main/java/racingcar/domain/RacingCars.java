package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int MAX_CAR_COUNT = 100;

    private final List<Car> cars;

    public static RacingCars from(List<Car> cars) {
        checkCarsValidation(cars);
        return new RacingCars(cars);
    }

    private static void checkCarsValidation(List<Car> cars) {
        if (isNullOrEmpty((cars))) {
            throw new RuntimeException("Cars is Empty.");
        }
        if (isOverMaxCount(cars)) {
            throw new RuntimeException("car too many. current car count: " + cars.size());
        }
        if (isContainsNull(cars)) {
            throw new RuntimeException("Cars has null.");
        }
        if (isDuplicated(cars)) {
            throw new RuntimeException("Car name Duplicate.");
        }
    }

    private static boolean isNullOrEmpty(List<Car> cars) {
        return Objects.isNull(cars) || cars.isEmpty();
    }

    private static boolean isOverMaxCount(List<Car> cars) {
        return cars.size() > MAX_CAR_COUNT;
    }

    private static boolean isContainsNull(List<Car> cars) {
        return cars.stream().anyMatch(Objects::isNull);
    }

    private static boolean isDuplicated(List<Car> cars) {
        return getDistinctCarsCount(cars) != cars.size();
    }

    private static int getDistinctCarsCount(List<Car> cars) {
        return (int) cars.stream()
                .distinct()
                .count();
    }

    private RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void progress() {
        cars.forEach(Car::moveOrStop);
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    public List<CarDto> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(getWinnerFilter(maxPosition))
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private Predicate<Car> getWinnerFilter(int maxPosition) {
        return car -> car.getPosition() == maxPosition;
    }

}
