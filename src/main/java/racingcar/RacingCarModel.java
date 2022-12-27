package racingcar;

import java.util.List;
import java.util.Objects;

public class RacingCarModel {

    private static final int MAX_CAR_COUNT = 100;
    private List<Car> cars;

    public static List<String> parseNames(String nameLine) {
        List<String> names = List.of(nameLine.split(","));
        if (names.size() > MAX_CAR_COUNT)
            throw new RuntimeException("car too many. current car count: " + names.size());
        return names;
    }

    public static RacingCarModel from(List<Car> cars) {
        return new RacingCarModel(cars);
    }

    private RacingCarModel(List<Car> cars) {
        checkCarsEmpty(cars);
        checkContainsNull(cars);
        checkNameDuplication(cars);
        this.cars = cars;
    }

    private void checkCarsEmpty(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new RuntimeException("Cars is Empty.");
        }
    }

    private void checkContainsNull(List<Car> cars) {
        if (cars.stream().anyMatch(Objects::isNull)) {
            throw new RuntimeException("Cars has null.");
        }
    }

    private void checkNameDuplication(List<Car> cars) {
        if (cars.stream()
                .map(car -> car.getCarInfo().getName())
                .distinct()
                .count() != cars.size()) {
            throw new RuntimeException("Car name Duplicate.");
        }
    }
}
