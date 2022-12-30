package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.service.RacingService;
import racingcar.util.Movable;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private RacingService racingService;
    private String names;
    private int trialNumber;


    public List<RacingCar> getWinners() {
        return racingService.getWinners();
    }

    public void inputNames(String names) {
        RacingService.validateCarNames(names);
        this.names = names;
    }

    public void inputTrialNumber(String trialNumber) {
        RacingService.validateTrialNumber(trialNumber);
        this.trialNumber = Integer.parseInt(trialNumber);
    }

    public void startRacing(Movable movable) {
        this.racingService = new RacingService(names, trialNumber, movable);
    }

    public boolean isRacingEnd() {
        return racingService.isRacingEnd();
    }

    public void proceedRound() {
        racingService.proceedRound();
    }

    public ArrayList<RacingCar> getCarsForPrintRoundResult() {
        return racingService.getCarsForPrintRoundResult();
    }

}
