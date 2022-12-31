package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberGeneratorImpl;

public class RacingGame {

    private final RandomMovementManager randomMovementManager;
    private final RacingCars racingCars;
    private int remainingRounds;

    public RacingGame(RacingCars racingCars, int remainingRounds) {
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingCars = racingCars;
        this.remainingRounds = remainingRounds;
    }

    public void playRound() {
        if (isFinished()) {
            throw new IllegalStateException("모든 라운드가 종료되었습니다.");
        }
        racingCars.moveAll(randomMovementManager);
        remainingRounds--;
    }

    public boolean isFinished() {
        return remainingRounds <= 0;
    }
}
