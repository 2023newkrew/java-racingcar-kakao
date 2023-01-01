package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.strategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarService implements Runnable {

    private final InputView inputView;
    private final ResultView resultView;
    private final MovingStrategy movingStrategy;


    public RacingCarService(InputView inputView, ResultView resultView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void run() {
        Cars cars = new Cars(inputView.getCars());
        int round = inputView.getRounds();

        RacingGame racingGame = new RacingGame(movingStrategy, cars, round);
        resultView.printInitialStatus(racingGame.getCars());
        while(!racingGame.isEnd()) {
            racingGame.race();
            resultView.printCars(racingGame.getCars());
        }
        resultView.printWinners(racingGame.getWinners());
    }

}
