package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.RacingCarView;

import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        Racing racing = new Racing();

        racing.addCars(racingCarView.inputCarNames().stream().map(Car::new).collect(Collectors.toList()));
        racing.setCount(racingCarView.inputCount());
        racingCarView.resultMessage();
        while (!racing.isFinished()) {
            racing.tryForward();
            racingCarView.printResultOfCars(racing.getCarList());
        }
        racingCarView.printWinners(racing.winner());
    }
}
