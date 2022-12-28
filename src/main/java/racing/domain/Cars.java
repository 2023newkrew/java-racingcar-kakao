package racing.domain;

import java.util.List;
import java.util.stream.Collectors;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class Cars {
    private final List<Car> cars;
    private final int length;
    private static final String RANDOM_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 정확히 자동차 개수만큼의 랜덤 값이 필요합니다.";

    public Cars(final List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        length = cars.size();
    }

    public void play(final List<Integer> randomNumbers) {
        if (randomNumbers.size() != length) {
            throw new IllegalArgumentException(RANDOM_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
        for (int i = 0; i < length; i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<CarDTO> getCarDtoList() {
        List<CarDTO> carDtoList = cars.stream()
                .map(Car::toDTO)
                .collect(Collectors.toList());
        return carDtoList;
    }

    public List<String> getWinners() {
        List<CarDTO> carDtoList = getCarDtoList();
        CarDtoDistanceComparator distanceComparator = new CarDtoDistanceComparator();
        carDtoList.sort(distanceComparator);
        CarDTO lastWinner = carDtoList.get(length - 1);
        List<String> winners = carDtoList.stream()
                .filter(car -> distanceComparator.compare(lastWinner, car) == 0)
                .map(CarDTO::getName)
                .collect(Collectors.toList());
        return winners;
    }

    public List<String> getStatus() {
        List<String> status = cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
        return status;
    }
}
