package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<CarName> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<CarDTO> getCarDtoList() {
        List<CarDTO> carDtoList = cars.stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
        return carDtoList;
    }

    public List<CarName> getWinners() {
        List<CarDTO> carDtoList = getCarDtoList();
        CarDtoDistanceComparator distanceComparator = new CarDtoDistanceComparator();
        carDtoList.sort(distanceComparator);
        CarDTO lastWinner = carDtoList.get(cars.size() - 1);
        List<CarName> winners = carDtoList.stream()
                .filter(car -> distanceComparator.compare(lastWinner, car) == 0)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
        return winners;
    }

    public List<CarDTO> getStatus() {
        List<CarDTO> status = cars.stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
        return status;
    }
}
