package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.AppConfig;
import racingcar.generator.RandomNumberGenerator;

public class RacingCarGameImpl implements RacingCarGame {
    private RandomNumberGenerator randomNumberGenerator;
    private ArrayList<Car> cars = new ArrayList<>();

    public RacingCarGameImpl(AppConfig appConfig) {
        randomNumberGenerator = appConfig.getRandomNumberGenerator();
    }

    @Override
    public void run(int times) {
        for (int i = 0; i < times; i++) {
            cars.forEach(car -> car.move(randomNumberGenerator.generator()));
        }
    }

    @Override
    public void add(String carName) {
        cars.add(new RacingCar(carName));
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

    private int getMaxDistance() {
        return cars.stream().max(Comparator.comparingInt(Car::getDistance)).orElseThrow().getDistance();
    }
}
