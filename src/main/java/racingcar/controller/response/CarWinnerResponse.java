package racingcar.controller.response;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarWinnerResponse {

    private final String carName;

    public CarWinnerResponse(Car car) {
        this.carName = car.getCarName();
    }

    public static CarWinnerResponse of(Car car) {
        return new CarWinnerResponse(car);
    }

    public static List<CarWinnerResponse> toList(List<Car> cars) {
        return cars.stream()
            .map(CarWinnerResponse::of)
            .collect(Collectors.toList());
    }

    public String getCarName() {
        return carName;
    }
}
