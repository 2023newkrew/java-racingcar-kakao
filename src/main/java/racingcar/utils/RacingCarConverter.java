package racingcar.utils;

import racingcar.domain.Car;
import racingcar.dto.CarInfo;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarConverter {

    public static Car toCar(CarInfo carDto) {
        return new Car(carDto.getName());
    }

    public static List<Car> toCars(List<CarInfo> carDtos) {
        return carDtos.stream()
                .map(RacingCarConverter::toCar)
                .collect(Collectors.toList());
    }

    public static List<CarInfo> toCarDtos(List<Car> cars) {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

}
