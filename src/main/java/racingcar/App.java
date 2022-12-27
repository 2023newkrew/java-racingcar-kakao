package racingcar;

import racingcar.engine.InputParser;
import racingcar.engine.RacingCar;
import racingcar.engine.RandomNumberGenerator;
import racingcar.engine.Referee;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        InputParser inputParser = new InputParser();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Referee referee = new Referee();

        RacingCar racingCar = new RacingCar(inputParser, randomNumberGenerator, referee, console);

        racingCar.run();
    }
}
