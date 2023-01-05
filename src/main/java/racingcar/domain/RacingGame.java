package racingcar.domain;

import racingcar.utils.RandomMovementManager;
import racingcar.utils.RandomNumberGeneratorImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final RandomMovementManager randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
    private final List<RacingCar> racingCars;

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void playRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
    }

    public List<RacingCar> selectWinners() {
        Collections.sort(racingCars, Collections.reverseOrder());
        RacingCar winner = racingCars.get(0);
        return racingCars.stream().filter(other -> winner.compareTo(other) == 0).collect(Collectors.toList());
    }
}
