package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.RacingCarView;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Racing racing = new Racing();

        racing.addCars(stringToCar(RacingCarView.inputCarNames()));
        racing.setCount(RacingCarView.inputCount());
        RacingCarView.resultMessage();
        while (racing.isNotFinished())
            RacingCarView.printResultOfCars(racing.tryForward());
        RacingCarView.printWinners(racing.winner());
    }

    private static List<Car> stringToCar(List<String> strings) {
        return strings.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
