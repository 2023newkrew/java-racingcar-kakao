package racingcar.model;

import racingcar.util.Movable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGroup {
    private final List<RacingCar> cars;

    public RacingCarGroup(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCarGroup(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
    }

    public void moveCars(Movable movable) {
        for (Car car : cars) {
            car.move(movable);
        }
    }

    public List<RacingCar> getWinners() {
        RacingCar winner = cars.stream().max(Comparator.comparingInt(RacingCar::getPosition)).orElse(null);
        return cars.stream()
                .filter(car -> car.getPosition() == winner.getPosition())
                .collect(Collectors.toList());
    }

    public List<RacingCar> getCarsList() {
        return Collections.unmodifiableList(cars);
    }
}
