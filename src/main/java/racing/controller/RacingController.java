package racing.controller;

import racing.service.RacingService;
import racing.service.RacingSplitter;
import racing.view.RacingTemplate;
import racing.repository.RacingCarRepository;

public class RacingController {
    private final RacingService racingService;
    private final RacingSplitter racingSplitter;
    private final RacingTemplate racingTemplate;

    public RacingController() {
        racingService = new RacingService();
        racingSplitter = new RacingSplitter();
        racingTemplate = new RacingTemplate();
    }

    public void raceStart(){
        String carString = racingTemplate.inputCarName();
        RacingCarRepository.init(racingSplitter.split(carString));
        Integer attempt = racingTemplate.inputAttempt();

        racingTemplate.printResultString();
        racingTemplate.printCurrentStatus();

        for (int i = 0; i < attempt; i++) {
            racingService.turn();
            racingTemplate.printCurrentStatus();
        }

        racingTemplate.printWinners();
    }
}
