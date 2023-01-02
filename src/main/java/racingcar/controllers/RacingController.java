package racingcar.controllers;

import java.util.List;
import java.util.function.Supplier;
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
        RacingGame racingGame = prepareGame();
        racingView.showCurrentStatus(racingGame.getCars());
        while (!racingGame.isEnd()) {
            racingGame.race();
            racingView.showCurrentStatus(racingGame.getCars());
        }
        racingView.showResult(racingGame.getWinners());
    }

    public RacingGame prepareGame() {
        return racingView.requestUntilSuccess(this::prepareGameLogic);
    }

    private RacingGame prepareGameLogic() {
        List<Car> cars = racingView.getCars();
        int count = racingView.getCount();
        return new RacingGame(cars, count, numberGenerator);
    }
}
