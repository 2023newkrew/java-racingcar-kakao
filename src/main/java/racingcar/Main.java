package racingcar;


import racingcar.controller.RacingController;
import racingcar.model.RacingService;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class Main {
    public static void main(String[] args) {
        RacingInputView riv = new RacingInputView();
        RacingOutputView rov = new RacingOutputView();

        String carNames = riv.inputNames();
        String trialNumbers = riv.inputTrialNumber();

        RacingService rs = new RacingService(carNames, trialNumbers);
        RacingController rc = new RacingController(rs);

        while (!rc.isRacingEnd()) {
            rc.proceedRound();
            rov.printRoundResult(rc.getCarsForPrintRoundResult());
        }
        rov.printWinners(rc.getWinners());
    }
}
