package racing.dto;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;

public class CarDTOs {
    private final List<CarDTO> carDtoList;

    private CarDTOs(List<CarDTO> carDtoList) {
        this.carDtoList = carDtoList;
    }

    public static CarDTOs of(List<Car> cars) {
        return new CarDTOs(cars.stream()
                .map(CarDTO::of)
                .collect(Collectors.toList()));
    }

    public static CarDTOs of(Cars cars) {
        return CarDTOs.of(cars.getCars());
    }

    public Iterable<CarDTO> getCarDtoList() {
        return carDtoList;
    }
}
