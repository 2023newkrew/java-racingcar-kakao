package racingcar.engine;

import java.util.List;
import racingcar.Console;
import racingcar.NumberGenerator;
import racingcar.engine.domain.Car;
import racingcar.engine.domain.RacingGame;
import racingcar.engine.view.RacingView;

public class RacingMain {

    private final RacingView racingView;

    private final NumberGenerator numberGenerator;

    public RacingMain(Console console, NumberGenerator numberGenerator) {
        this.racingView = new RacingView(console);
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<Car> cars = racingView.getCars();
        int count = racingView.getCount();
        RacingGame racingGame = new RacingGame(cars, count, numberGenerator);
        racingView.showCurrentStatus(cars);
        while (!racingGame.isEnd()) {
            racingGame.race();
            racingView.showCurrentStatus(cars);
        }
        racingView.showResult(racingGame.getWinners());
    }
}
