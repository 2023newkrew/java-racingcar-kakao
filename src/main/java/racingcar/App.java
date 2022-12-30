package racingcar;

import racingcar.engine.RacingMain;

public class App {
    public static void main(String[] args) {
        Console console = new StandardConsole();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingMain racingMain = new RacingMain(console, numberGenerator);

        racingMain.run();
    }
}
