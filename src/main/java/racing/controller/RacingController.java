package racing.controller;

import racing.service.RacingService;
import racing.service.RacingSplitter;
import racing.repository.RacingCarRepository;
import racing.view.RacingInputTemplate;
import racing.view.RacingOutputTemplate;

public class RacingController {
    private final RacingSplitter racingSplitter;
    private final RacingInputTemplate racingInputTemplate;

    public RacingController() {
        racingSplitter = new RacingSplitter();
        racingInputTemplate = new RacingInputTemplate();
    }

    public void raceStart(){
        String carString = racingInputTemplate.inputCarName();
        RacingCarRepository racingCarRepository = new RacingCarRepository(racingSplitter.split(carString));
        RacingService racingService = new RacingService(racingCarRepository);
        RacingOutputTemplate racingOutputTemplate = new RacingOutputTemplate(racingCarRepository);
        Integer attempt = racingInputTemplate.inputAttempt();

        racingOutputTemplate.printResultString();
        racingOutputTemplate.printCurrentStatus();

        for (int i = 0; i < attempt; i++) {
            racingService.turn();
            racingOutputTemplate.printCurrentStatus();
        }

        racingOutputTemplate.printWinners();
    }
}
