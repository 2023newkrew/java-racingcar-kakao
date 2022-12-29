package racingcar;

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
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
        remainingRounds--;
        return racingCars;
    }

    public boolean isFinished() {
        return remainingRounds == 0;
    }
}
