package racingcar.step2.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String ERR_NAME_DUPLICATED = "자동차 이름은 중복될 수 없습니다.";

    private final List<Car> carList;

    public Cars(List<String> carNames) {
        List<Car> cars = createCars(carNames);
        validateDuplicatedName(cars);

        this.carList = cars;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        return cars;
    }

    private void validateDuplicatedName(List<Car> cars) {
        if (cars.size() != cars.stream().map(Car::getName).distinct().count())
                throw new IllegalArgumentException(ERR_NAME_DUPLICATED);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAll() {
        carList.forEach(Car::tryToMove);
    }

    public List<String> selectWinners(int position) {
        return carList.stream()
                .filter(c -> c.isInPosition(position))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElse(0);
    }
}
