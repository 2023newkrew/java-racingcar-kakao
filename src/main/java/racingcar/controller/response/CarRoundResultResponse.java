package racingcar.controller.response;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarRoundResultResponse {

    private final String carName;
    private final int position;

    public CarRoundResultResponse(Car car) {
        this.carName = car.getCarName();
        this.position = car.getPosition();
    }

    public static CarRoundResultResponse of(Car car) {
        return new CarRoundResultResponse(car);
    }

    public static List<CarRoundResultResponse> toList(List<Car> cars) {
        return cars.stream()
            .map(CarRoundResultResponse::of)
            .collect(Collectors.toList());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
