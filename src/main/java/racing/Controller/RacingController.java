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

        System.out.println("\n실행 결과");
        System.out.println(simulator + "\n");
        for (int i = 0; i < times; i++) {
            simulator.run(new Random());
            System.out.println(simulator + "\n");
        }

        System.out.println(simulator.winners() + "가 최종 우승했습니다.");
    }
}
