package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingSimulator;
import racingcar.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View(System.out, System.in);
        List<String> carNames = view.inputCarNames();
        int maxTryCount = view.inputMaxTryCount();


        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

    }
}
