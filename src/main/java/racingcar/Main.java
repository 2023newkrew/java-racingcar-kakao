package racingcar;


import racingcar.controller.RacingController;
import racingcar.view.RacingView;

public class Main {
    public static void main(String[] args) {
        RacingController rc = new RacingController();
        RacingView rv = new RacingView(rc);

        rv.inputNames();
        rv.inputTrialNumber();
        rc.startRacing();
        while (!rc.isRacingEnd()) {
            rc.proceedRound();
            rv.printRoundResult();
        }
        rv.printWinners();
    }
}
