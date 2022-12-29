package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingGameScoreView racingGameScoreView;
    private final RandomMovementManager randomMovementManager;
    private final RacingGameReferee racingGameReferee;

    private final List<RacingCar> racingCars;
    private int remainingRounds;

    public RacingGame() {
        this.racingGameScoreView = new RacingGameScoreView();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingGameReferee = new RacingGameReferee();
        this.racingCars = new ArrayList<>();
        this.remainingRounds = 0;
    }

    public RacingGame(List<RacingCar> racingCars, int remainingRounds) {
        this.racingGameScoreView = new RacingGameScoreView();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingGameReferee = new RacingGameReferee();
        this.racingCars = racingCars;
        this.remainingRounds = remainingRounds;
    }

    public void play(List<RacingCar> racingCars, int rounds) {
        System.out.println("\n실행 결과");
        racingGameScoreView.printRacingCarDist(racingCars);
        for (int round = 0; round < rounds; round++) {
            playRound(racingCars);
            racingGameScoreView.printRacingCarDist(racingCars);
        }
        racingGameScoreView.printWinners(racingGameReferee.findWinners(racingCars));
    }

    private void playRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
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
