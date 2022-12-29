package racingcar;

import java.util.List;

public class RacingGame {

    private final RacingGameScoreView racingGameScoreView;
    private final RandomMovementManager randomMovementManager;
    private final RacingGameReferee racingGameReferee;

    public RacingGame() {
        this.racingGameScoreView = new RacingGameScoreView();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingGameReferee = new RacingGameReferee();
    }

    public void play(List<RacingCar> racingCars, int rounds) {
        System.out.println("\n실행 결과");
        racingGameScoreView.printScore(racingCars);
        for (int round = 0; round < rounds; round++) {
            playRound(racingCars);
            racingGameScoreView.printScore(racingCars);
        }
        racingGameScoreView.printWinners(racingGameReferee.findWinners(racingCars));
    }

    private void playRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
    }
}
