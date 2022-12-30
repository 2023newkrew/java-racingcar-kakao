package racingcar;

import racingcar.controllers.RacingController;
import racingcar.models.NumberGenerator;
import racingcar.models.RandomNumberGenerator;
import racingcar.views.Console;
import racingcar.views.StandardConsole;

public class RacingApp {
    public static void main(String[] args) {
        Console console = new StandardConsole();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingController racingController = new RacingController(console, numberGenerator);

        racingController.run();
    }
}
