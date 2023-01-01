package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.Racing;

import java.util.List;

public class RacingController {
    private Racing racing;
    private String names;
    private int trialNumber;


    public List<RacingCar> getWinners() {
        return racing.getWinners();
    }

    public void processCarNames(String names) {
        Racing.validateCarNames(names);
        this.names = names;
    }

    public void processTrialNumber(String trialNumber) {
        Racing.validateTrialNumber(trialNumber);
        this.trialNumber = Integer.parseInt(trialNumber);
    }
    public void startRacing() {
        this.racing = new Racing(names, trialNumber);
    }

    public boolean isRacingEnd() {
        return racing.isRacingEnd();
    }

    public void proceedRound() {
        racing.proceedRound();
    }

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racing.getCarsForPrintRoundResult();
    }

}
