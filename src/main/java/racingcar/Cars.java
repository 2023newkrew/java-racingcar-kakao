package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        for (Car car: carList){
            car.move();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> findWinners(){
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getCarList().stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
