package racingcar.controllers;

import java.util.List;
import racingcar.views.Console;
import racingcar.models.NumberGenerator;
import racingcar.models.Car;
import racingcar.models.RacingGame;
import racingcar.views.RacingView;

public class RacingController {

    private final RacingView racingView;

    private final NumberGenerator numberGenerator;

    public RacingController(Console console, NumberGenerator numberGenerator) {
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
