package racing.controller;

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

        simulator.simulate(new Random(), times);
        racingView.printResults(simulator);
    }
}
