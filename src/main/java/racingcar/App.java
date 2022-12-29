package racingcar;

import racingcar.engine.RacingMain;
import racingcar.engine.view.RacingView;

public class App {
    public static void main(String[] args) {
        Console console = new StandardConsole();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingView racingView = new RacingView(console);

        RacingMain racingMain = new RacingMain(racingView, numberGenerator);

        racingMain.run();
    }
}
