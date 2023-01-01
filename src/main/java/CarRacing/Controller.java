package CarRacing;

import CarRacing.domain.Racing;
import CarRacing.domain.RacingResult;
import CarRacing.view.InputView;
import CarRacing.view.ResultView;

public class Controller {
    public static void RacingGame() {
        String inputNames = InputView.inputNames();
        String inputCount = InputView.inputCount();
        Racing racing = new Racing(inputNames, inputCount);
        RacingResult racingResult = racing.playRacing();
        ResultView.printRacingResult(racingResult);
    }
}
