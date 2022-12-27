package racingcar.utils;

import racingcar.domain.Car;
import racingcar.dto.CarDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarConverter {

    public static Car toCar(CarDto carDto) {
        return new Car(carDto.getName());
    }

    public static List<Car> toCars(List<CarDto> carDtos) {
        return carDtos.stream()
                .map(RacingCarConverter::toCar)
                .collect(Collectors.toList());
    }

    public static List<CarDto> toCarDtos(List<Car> cars) {
        return cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public static List<CarDto> toCarDtos(String[] carNames) {
        return Arrays.stream(carNames)
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

}
