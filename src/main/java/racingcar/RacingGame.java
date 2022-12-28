package racingcar;

import java.util.List;

public class RacingGame {

    private final RacingScoreboard racingScoreboard;
    private final RandomMovementManager randomMovementManager;
    private final RacingGameReferee racingGameReferee;

    public RacingGame() {
        this.racingScoreboard = new RacingScoreboard();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingGameReferee = new RacingGameReferee();
    }

    public void play(List<RacingCar> racingCars, int rounds) {
        System.out.println("실행 결과");
        racingScoreboard.printScore(racingCars);
        for (int round = 0; round < rounds; round++) {
            playRound(racingCars);
            racingScoreboard.printScore(racingCars);
        }
        racingScoreboard.printWinners(racingGameReferee.findWinners(racingCars));
    }

    private void playRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
    }
}
