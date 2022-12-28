package racingcar;

import racingcar.engine.InputParser;
import racingcar.engine.RacingGame;
import racingcar.engine.RandomNumberGenerator;
import racingcar.engine.Referee;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        InputParser inputParser = new InputParser();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(inputParser, randomNumberGenerator, referee, console);

        racingGame.run();
    }
}
