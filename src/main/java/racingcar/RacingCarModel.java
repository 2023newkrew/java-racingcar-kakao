package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingCarModel {

    private static final int MAX_CAR_COUNT = 100;

    private final List<Car> cars;

    public static RacingCarModel from(List<Car> cars) {
        checkCarsValidation(cars);
        return new RacingCarModel(cars);
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

    private RacingCarModel(List<Car> cars) {
        this.cars = cars;
    }

    public void progress() {
        cars.forEach(Car::moveOrStop);
    }

    public List<CarDto> getWinners() {
        List<CarDto> carDtos = getCarDtos();
        int maxPosition = getMaxPosition(carDtos);
        return getWinners(carDtos, maxPosition);
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(Car::getCarInfo)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<CarDto> carDtos) {
        return carDtos.stream()
                .mapToInt(CarDto::getPosition)
                .max()
                .getAsInt();
    }

    private List<CarDto> getWinners(List<CarDto> carDtos, int maxPosition) {
        return carDtos.stream()
                .filter(getWinnerFilter(maxPosition))
                .collect(Collectors.toList());
    }

    private Predicate<CarDto> getWinnerFilter(int maxPosition) {
        return carInfo -> carInfo.getPosition() == maxPosition;
    }

}
