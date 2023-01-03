package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameWinners {
    List<RacingCar> winners;

    public RacingGameWinners(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException("비어있는 자동차 목록입니다.");
        }
        this.winners = findWinners(racingCars);
    }

    public List<RacingCar> getWinners() {
        return winners;
    }

    private List<RacingCar> findWinners(List<RacingCar> racingCars) {
        RacingCar winner = Collections.max(racingCars);
        return racingCars.stream()
                .filter(racingCar -> winner.getDistance() == racingCar.getDistance())
                .collect(Collectors.toUnmodifiableList());
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
        return Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
