package racingcar;

import java.util.List;

public class RacingGame {

    private final RacingGameInfoReader racingGameInfoReader;
    private final RacingScoreboard racingScoreboard;
    private final RandomMovementManager randomMovementManager;
    private final RacingGameReferee racingGameReferee;

    public RacingGame() {
        this.racingGameInfoReader = new RacingGameInfoReader();
        this.racingScoreboard = new RacingScoreboard();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
        this.racingGameReferee = new RacingGameReferee();
    }

    public void play() {
        List<RacingCar> racingCars = racingGameInfoReader.readRacingCars();
        int round = racingGameInfoReader.readRound();
        System.out.println("실행 결과");
        racingScoreboard.printScore(racingCars);
        for (int roundNum = 0; roundNum < round; roundNum++) {
            playRound(racingCars);
            racingScoreboard.printScore(racingCars);
        }
        racingScoreboard.printWinners(racingGameReferee.findWinners(racingCars));
        racingGameInfoReader.close();
    }

    private void playRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
    }
}
