package racingcar.domain;

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
        Position maxPosition = carList.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElse(new Position(0));

        return carList.stream()
                .filter(car -> maxPosition.equals(car.getPosition()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return getCarList().stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
