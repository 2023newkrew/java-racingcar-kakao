package racingcar.controller;

import racingcar.exception.RacingException;
import racingcar.exception.RacingExceptionCode;
import racingcar.model.RacingCar;
import racingcar.model.RacingService;

import java.util.List;

public class RacingController {
    private RacingService racing;
    private String names;
    private int trialNumber = 0;


    public List<RacingCar> getWinners() {
        return racing.getWinners();
    }

    public void setCarNames(String names) {
        RacingService.validateCarNames(names);
        this.names = names;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = RacingService.validateTrialNumber(trialNumber);
    }
    public void startRacing() {
        this.racing = new RacingService(names, trialNumber);
    }

    public boolean isRacingEnd() {
        if (racing == null) {
            throw new RacingException(RacingExceptionCode.RACING_NOT_STARTED);
        }
        return racing.isRacingEnd();
    }

    public void proceedRound() {
        if (racing == null) {
            throw new RacingException(RacingExceptionCode.RACING_NOT_STARTED);
        }
        racing.proceedRound();
    }

    public List<RacingCar> getCarsForPrintRoundResult() {
        return racing.getCarsForPrintRoundResult();
    }

}
