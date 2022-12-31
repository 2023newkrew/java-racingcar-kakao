package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameWinners {
    List<RacingCar> racingCars;

    public RacingGameWinners(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingGameWinners that = (RacingGameWinners) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }

    @Override
    public String toString() {
        String winnerNames = racingCars.stream()
                .map(RacingCar::getRacingCarName)
                .map(RacingCarName::getName)
                .collect(Collectors.joining(", "));
        return winnerNames + "가 최종 우승했습니다.";
    }
}
