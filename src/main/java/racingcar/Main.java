package racingcar;


import racingcar.controller.RacingController;
import racingcar.util.RandomMovable;
import racingcar.view.RacingView;

public class Main {
    public static void main(String[] args) {
        RacingController rc = new RacingController();
        RacingView rv = new RacingView(rc);

        rv.inputNames();
        rv.inputTrialNumber();
        rc.startRacing(new RandomMovable(10, 4));
        while (!rc.isRacingEnd()) {
            rc.proceedRound();
            rv.printRoundResult();
        }
        rv.printWinners();
    }
}
