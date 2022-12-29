package racingcar.domain;

import racingcar.domain.model.RacingCar;
import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CarContainer {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> getCars() {
        return racingCars;
    }

    public void add(RacingCar other) {
        if (hasDuplicatedCar(other)) {
            throw new RuntimeException();
        }
        racingCars.add(other);
    }

    public void moveAll() {
        RandomUtil randomUtil = new RandomUtil();
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomUtil.generateRandom());
        }
    }

    public List<RacingCar> selectWinners() {
        List<RacingCar> winners = new ArrayList<>();
        OptionalInt maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max();
        if (maxPosition.isEmpty()) {
            return winners;
        }
        racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition.getAsInt())
                .forEach(winners::add);
        return winners;
    }

    private boolean hasDuplicatedCar(RacingCar other) {
        return racingCars.stream()
                .anyMatch(car -> car.equals(other));
    }
}
