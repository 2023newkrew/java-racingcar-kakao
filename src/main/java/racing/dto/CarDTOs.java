package racing.dto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.Cars;

public class CarDTOs {
    private final List<CarDTO> carDtoList;

    public CarDTOs(List<CarDTO> carDtoList) {
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

    public List<CarName> getWinners(Comparator<CarDTO> comparator) {
        CarDTO lastWinnerDTO = getLastWinnerDTO(comparator);
        return carDtoList.stream()
                .filter(carDTO -> comparator.compare(lastWinnerDTO, carDTO) == 0)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
    }

    private CarDTO getLastWinnerDTO(Comparator<CarDTO> comparator) {
        return carDtoList.stream().max(comparator).get();
    }
}
