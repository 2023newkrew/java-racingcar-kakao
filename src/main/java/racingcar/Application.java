package racingcar;

import java.util.Random;
import racingcar.model.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.out, System.in);
        OutputView outputView = new OutputView(System.out);
        NumberGenerator randomNumberGenerator = () -> new Random().nextInt(9);

        RacingSimulator racingSimulator = new RacingSimulator(inputView, outputView);
        racingSimulator.simulate(randomNumberGenerator);
    }
}
