package racingcar;


import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class Main {
    public static void main(String[] args) {
        RacingController rc = new RacingController();
        RacingView rv = new RacingView();

        rc.processCarNames(rv.inputNames());
        rc.processTrialNumber(rv.inputTrialNumber());
        rc.startRacing();
        while (!rc.isRacingEnd()) {
            rc.proceedRound();
            rv.printRoundResult(rc.getCarsForPrintRoundResult());
        }
        rv.printWinners(rc.getWinners());
    }
}
