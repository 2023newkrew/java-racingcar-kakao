package racing.controller;

import racing.service.RacingService;
import racing.view.RacingInputTemplate;
import racing.view.RacingOutputTemplate;

public class RacingController {
    private final RacingInputTemplate racingInputTemplate;
    private final RacingOutputTemplate racingOutputTemplate;
    private final RacingService racingService;

    public RacingController() {
        racingInputTemplate = new RacingInputTemplate();
        racingOutputTemplate = new RacingOutputTemplate();
        racingService = new RacingService();
    }

    public void raceStart(){
        String carString = racingInputTemplate.inputCarName();
        racingService.insertCars(carString);

        Integer attempt = racingInputTemplate.inputAttempt();

        racingOutputTemplate.printResultString();
        racingOutputTemplate.printCurrentStatus(racingService.getCarStatusStrings());

        for (int i = 0; i < attempt; i++) {
            racingService.cycleProgress();
            racingOutputTemplate.printCurrentStatus(racingService.getCarStatusStrings());
        }

        racingOutputTemplate.printWinners(racingService.getWinnerCarNames());
    }
}
