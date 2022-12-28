package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RacingGameInfoReader racingGameInfoReader;
    private final RacingScoreboard racingScoreboard;
    private final RandomMovementManager randomMovementManager;

    public RacingGame() {
        this.racingGameInfoReader = new RacingGameInfoReader();
        this.racingScoreboard = new RacingScoreboard();
        this.randomMovementManager = new RandomMovementManager(new RandomNumberGeneratorImpl());
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
        racingScoreboard.printWinners(selectWinners(racingCars));
        racingGameInfoReader.close();
    }

    private List<RacingCar> selectWinners(List<RacingCar> racingCars) {
        Collections.sort(racingCars, Collections.reverseOrder());
        RacingCar winner = racingCars.get(0);
        return racingCars.stream().filter(other -> winner.compareTo(other) == 0).collect(Collectors.toList());
    }

    private void playRound(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(randomMovementManager.makeMovementDecision());
        }
    }
}
