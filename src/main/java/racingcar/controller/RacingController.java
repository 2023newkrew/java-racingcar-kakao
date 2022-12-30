package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {
    private RacingService racingService;
    private String names;
    private int trialNumber;


    public List<RacingCar> getWinners() {
        return racingService.getWinners();
    }

    public void processCarNames(String names) {
        RacingService.validateCarNames(names);
        this.names = names;
    }

    public void processTrialNumber(String trialNumber) {
        RacingService.validateTrialNumber(trialNumber);
        this.trialNumber = Integer.parseInt(trialNumber);
    }
    public void startRacing() {
        this.racingService = new RacingService(names, trialNumber);
    }

    public boolean isRacingEnd() {
        return racingService.isRacingEnd();
    }

    public void proceedRound() {
        racingService.proceedRound();
    }

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racingService.getCarsForPrintRoundResult();
    }

}
