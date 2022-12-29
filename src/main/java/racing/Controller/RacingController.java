package racing.Controller;

import racing.domain.Simulator;
import racing.view.RacingView;

import java.util.Random;

public class RacingController {
    private final RacingView racingView = new RacingView();

    public void run() {
        String names = racingView.inputCarNames();
        int times = racingView.inputTimes();

        Simulator simulator = new Simulator();
        simulator.create(names);

        racingView.printStartSimulator(simulator);
        for (int i = 0; i < times; i++) {
            simulator.run(new Random());
            racingView.printSimulator(simulator);
        }

        racingView.printWinners(simulator);
    }
}
