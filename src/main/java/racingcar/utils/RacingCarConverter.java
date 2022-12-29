package racingcar.utils;

import racingcar.controller.dto.CarRequest;
import racingcar.service.dto.CarResponse;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarConverter {

    public static Car toCar(CarRequest carRequests) {
        return new Car(carRequests.getName());
    }

    public static List<Car> toCars(List<CarRequest> carRequests) {
        return carRequests.stream()
                .map(RacingCarConverter::toCar)
                .collect(Collectors.toList());
    }

    public static List<CarResponse> toCarResponses(List<Car> cars) {
        return cars.stream()
                .map(Car::toResponse)
                .collect(Collectors.toList());
    }

    public static List<CarRequest> toCarRequests(String[] carNames) {
        return Arrays.stream(carNames)
                .map(CarRequest::new)
                .collect(Collectors.toList());
    }

}
