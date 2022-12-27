package racingcar;

import racingcar.engine.model.InputParser;
import racingcar.engine.model.RacingCar;
import racingcar.engine.model.RandomNumberGenerator;
import racingcar.engine.model.Referee;

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
