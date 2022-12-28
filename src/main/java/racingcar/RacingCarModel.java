package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void progress() {
        cars.forEach(Car::moveOrStop);
    }

    public List<CarInfo> getCarInfos() {
        return cars.stream()
                .map(Car::getCarInfo)
                .collect(Collectors.toList());
    }

    public List<CarInfo> getWinners() {
        List<CarInfo> carInfos = getCarInfos();
        int maxPosition = getMaxPosition(carInfos);
        return carInfos.stream()
                .filter(carInfo -> isWinnerCar(carInfo, maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<CarInfo> carInfos) {
        return carInfos.stream()
                .mapToInt(CarInfo::getPosition)
                .max()
                .getAsInt();
    }

    private boolean isWinnerCar(CarInfo carInfo, int maxPosition) {
        return carInfo.getPosition() == maxPosition;
    }
}
