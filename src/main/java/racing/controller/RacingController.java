package racing.controller;

import racing.service.RacingService;
import racing.service.CarNameSplitter;
import racing.view.RacingView;
import racing.repository.RacingCarRepository;

public class RacingController {
    private final RacingService racingService;
    private final CarNameSplitter carNameSplitter;
    private final RacingView racingView;

    public RacingController() {
        racingService = new RacingService();
        carNameSplitter = new CarNameSplitter();
        racingView = new RacingView();
    }

    public void raceStart(){
        String carString = racingView.inputCarName();
        RacingCarRepository.init(carNameSplitter.split(carString));
        Integer attempt = racingView.inputAttempt();

        racingView.printResultString();
        racingView.printCurrentStatus();

        for (int i = 0; i < attempt; i++) {
            racingService.turn();
            racingView.printCurrentStatus();
        }

        racingView.printWinners();
    }
}
