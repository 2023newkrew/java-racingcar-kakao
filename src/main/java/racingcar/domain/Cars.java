package racingcar.domain;

import racingcar.service.dto.CarResponse;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String CALCULATE_MAX_CAR_ERROR_MESSAGE = "가장 많이 움직인 자동차를 판별할 수 없습니다.";

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
                .map(CarResponse::of)
                .collect(Collectors.toList());
    }

    private Car calculateMaxPositionCar() {
        return cars.stream()
                .max(Car::comparePosition)
                .orElseThrow(() -> new RuntimeException(CALCULATE_MAX_CAR_ERROR_MESSAGE));
    }

    public List<CarResponse> toCarResponses() {
        return cars.stream()
                .map(CarResponse::of)
                .collect(Collectors.toList());
    }

}
