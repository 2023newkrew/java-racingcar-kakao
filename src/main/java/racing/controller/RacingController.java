package racing.controller;

import racing.service.RacingService;
import racing.service.RacingSplitter;
import racing.view.RacingView;
import racing.repository.RacingCarRepository;

public class RacingController {
    private final RacingService racingService;
    private final RacingSplitter racingSplitter;
    private final RacingView racingView;

    public RacingController() {
        racingService = new RacingService();
        racingSplitter = new RacingSplitter();
        racingView = new RacingView();
    }

    public void raceStart(){
        String carString = racingView.inputCarName();
        RacingCarRepository.init(racingSplitter.split(carString));
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
