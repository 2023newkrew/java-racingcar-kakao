package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameReferee {
    public List<RacingCar> findWinners(List<RacingCar> racingCars) {
        RacingCar winner = Collections.max(racingCars);
        return racingCars.stream().
                filter(other -> winner.getDistance() == other.getDistance())
                .collect(Collectors.toList());
    }
}
