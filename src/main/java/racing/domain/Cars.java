package racing.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private static final String RANDOM_NUMBER_COUNT_EXCEPTION_MESSAGE = "[ERROR] 정확히 자동차 개수만큼의 랜덤 값이 필요합니다.";
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play(List<Integer> randomNumbers) {
        int length = cars.size();
        if (randomNumbers.size() != length) {
            throw new IllegalArgumentException(RANDOM_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
        for (int i = 0; i < length; i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<String> getWinners() {
        Integer maxDistance = getMaxDistance();
        List<String> winners = cars.stream()
                .filter(car -> car.equalsDistance(maxDistance))
                .map(Car::getName).collect(Collectors.toList());
        return winners;
    }

    private Integer getMaxDistance() {
        Integer maxDistance = cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
        return maxDistance;
    }

    public List<String> getStatus() {
        List<String> status = cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
        return status;
    }
}
