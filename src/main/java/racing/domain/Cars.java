package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final int length;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        length = cars.size();
    }

    public void play(List<Double> randomNumbers) {
        if (randomNumbers.size() != length) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < length; i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<String> getWinners() {
        Collections.sort(cars);
        Car winnerCar = cars.get(length - 1);
        List<String> winners = cars.stream()
                .filter(car -> car.compareTo(winnerCar) == 0)
                .map(Car::getName)
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
