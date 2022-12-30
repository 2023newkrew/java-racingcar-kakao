package racing.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getSamePosCars(Car other) {
        return cars.stream()
                .filter(car -> car.isSamePos(other))
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        Car maxPosCar = cars.stream().max(Car::comparePos).orElseThrow();
        return getSamePosCars(maxPosCar);
    }

    public String getWinnerNames() {
        List<Car> winnerCars = getWinners();
        return winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

}
