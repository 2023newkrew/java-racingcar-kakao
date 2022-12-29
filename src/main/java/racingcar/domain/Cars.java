package racingcar.domain;

import racingcar.service.dto.CarResponse;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(Movable movable) {
        cars.forEach(car -> car.move(movable));
    }

    public List<CarResponse> selectWinners() {
        Car maxPositionCar = calculateMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::toResponse)
                .collect(Collectors.toList());
    }

    private Car calculateMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow();
    }

    public List<CarResponse> toCarResponses() {
        return cars.stream()
                .map(Car::toResponse)
                .collect(Collectors.toList());
    }

}
