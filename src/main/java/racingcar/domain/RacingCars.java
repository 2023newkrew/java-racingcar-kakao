package racingcar.domain;

import racingcar.service.RandomMovementManager;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String[] racingCarNames) {
        this.racingCars = Arrays.stream(racingCarNames)
                .map(RacingCar::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public RacingCars moveAll(RandomMovementManager randomMovementManager) {
        racingCars.forEach(racingCar -> racingCar.move(randomMovementManager.makeMovementDecision()));
        return this;
    }

    public int getNumOfRacingCars() {
        return racingCars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }

    @Override
    public String toString() {
        return racingCars.stream()
                .map(RacingCar::toString)
                .collect(Collectors.joining("\n"));
    }
}
