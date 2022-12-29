package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingCarModel {

    private static final int MAX_CAR_COUNT = 100;
    private final List<Car> cars;

    public static List<String> parseNames(String nameLine) {
        List<String> names = splitNames(nameLine);
        checkNamesSize(names);
        return names;
    }

    private static List<String> splitNames(String nameLine) {
        return List.of(nameLine.split(","));
    }

    private static void checkNamesSize(List<String> names) {
        if (names.size() > MAX_CAR_COUNT) {
            throw new RuntimeException("car too many. current car count: " + names.size());
        }
    }

    public static RacingCarModel from(List<Car> cars) {
        return new RacingCarModel(cars);
    }

    private RacingCarModel(List<Car> cars) {
        this.cars = cars;
        checkCarsValidation();
    }

    private void checkCarsValidation() {
        checkCarsEmpty();
        checkContainsNull();
        checkNameDuplication();
    }

    private void checkCarsEmpty() {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new RuntimeException("Cars is Empty.");
        }
    }

    private void checkContainsNull() {
        if (cars.stream().anyMatch(Objects::isNull)) {
            throw new RuntimeException("Cars has null.");
        }
    }

    private void checkNameDuplication() {
        if (getDistinctCarsCount() != cars.size()) {
            throw new RuntimeException("Car name Duplicate.");
        }
    }

    private int getDistinctCarsCount() {
        return (int) cars.stream()
                .map(car -> car.getCarInfo().getName())
                .distinct()
                .count();
    }

    public void progress() {
        cars.forEach(Car::moveOrStop);
    }

    public List<CarDto> getCarInfos() {
        return cars.stream()
                .map(Car::getCarInfo)
                .collect(Collectors.toList());
    }

    public List<CarDto> getWinners() {
        List<CarDto> carDtos = getCarInfos();
        int maxPosition = getMaxPosition(carDtos);
        return getWinners(carDtos, maxPosition);
    }

    private int getMaxPosition(List<CarDto> carDtos) {
        return carDtos.stream()
                .mapToInt(CarDto::getPosition)
                .max()
                .getAsInt();
    }

    private Predicate<CarDto> getWinnerFilter(int maxPosition) {
        return carInfo -> carInfo.getPosition() == maxPosition;
    }

    private List<CarDto> getWinners(List<CarDto> carDtos, int maxPosition) {
        return carDtos.stream()
                .filter(getWinnerFilter(maxPosition))
                .collect(Collectors.toList());
    }

}
