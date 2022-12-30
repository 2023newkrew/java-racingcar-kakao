package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RandomNumberGeneratorImpl;

import java.util.List;

public class RacingGame {

    private final RandomMovementManager randomMovementManager;
    private final List<RacingCar> racingCars;
    private int remainingRounds;

    public RacingGame(List<RacingCar> racingCars, int remainingRounds) {
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingCars = racingCars;
        this.remainingRounds = remainingRounds;
    }

    public List<RacingCar> playRound() {
        if (isFinished()) {
            throw new IllegalStateException("모든 라운드가 종료되었습니다.");
        }
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
        remainingRounds--;
        return racingCars;
    }

    public boolean isFinished() {
        return remainingRounds <= 0;
    }
}
