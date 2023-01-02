package racingcar;


import racingcar.controller.RacingController;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class Main {
    public static void main(String[] args) {
        RacingController rc = new RacingController();
        RacingInputView riv = new RacingInputView();
        RacingOutputView rov = new RacingOutputView();

        rc.setCarNames(riv.inputNames());
        rc.setTrialNumber(riv.inputTrialNumber());
        rc.startRacing();
        while (!rc.isRacingEnd()) {
            rc.proceedRound();
            rov.printRoundResult(rc.getCarsForPrintRoundResult());
        }
        rov.printWinners(rc.getWinners());
    }
}
