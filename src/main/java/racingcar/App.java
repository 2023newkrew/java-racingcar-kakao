package racingcar;

import racingcar.service.Racing;
import racingcar.view.RacingCarView;

public class App {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        Racing racing = new Racing();

        racing.addCars(racingCarView.inputCarNames());
        racing.setCount(racingCarView.inputCount());
        racingCarView.resultMessage();
        while (!racing.isFinished()) {
            racing.doStep();
            racingCarView.printResultOfCars(racing.getCarList());
        }
        racingCarView.printWinners(racing.winner());
    }
}
