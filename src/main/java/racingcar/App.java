package racingcar;

import racingcar.domain.Racing;
import racingcar.view.RacingCarView;

import java.util.List;

public class App {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        List<String> carNames = racingCarView.inputCarNames();
        int count=  racingCarView.inputCount();

        Racing racing = new Racing(carNames, count);
        racingCarView.resultMessage();
        while (!racing.isFinished()) {
            racing.doStep();
            racingCarView.printResultOfCars(racing.getCarList());
        }
        racingCarView.printWinners(racing.winner());
    }
}
