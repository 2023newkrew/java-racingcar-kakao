package racingcar;

import racingcar.service.RacingCarService;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomValueMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class App {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView(resultView);
        MovingStrategy movingStrategy = new RandomValueMovingStrategy();

        RacingCarService racingCarService = new RacingCarService(inputView, resultView, movingStrategy);

        racingCarService.run();
    }
}
