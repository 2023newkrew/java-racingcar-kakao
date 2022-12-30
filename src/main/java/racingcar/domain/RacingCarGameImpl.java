package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameImpl implements RacingCarGame {
    private final RandomNumberGenerator randomNumberGenerator;
    private final ArrayList<Car> cars = new ArrayList<>();

    public RacingCarGameImpl(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void run() {
        cars.forEach(car -> car.move(randomNumberGenerator.generate()));
    }

    @Override
    public void add(Set<String> names) {
        names.forEach(name -> this.cars.add(new RacingCar(name)));
    }


    @Override
    public void add(Car... multipleCar) {
        cars.addAll(List.of(multipleCar));
    }

    @Override
    public List<Car> getWinner() {
        int maxDistance = getMaxDistance();
        return cars.stream().filter(car -> maxDistance == car.getDistance()).collect(Collectors.toList());
    }

    @Override
    public List<String> getWinnerNames() {
        return getWinner().stream().map(Car::getName).collect(Collectors.toList());
    }


    @Override
    public List<String> getCarResults() {
        return cars.stream().map(Car::toString).collect(Collectors.toList());
    }


    private int getMaxDistance() {
        return cars.stream().max(Comparator.comparingInt(Car::getDistance)).orElseThrow().getDistance();
    }
}
