package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingService;

import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public List<RacingCar> getWinners() {
        return racingService.getWinners();
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
