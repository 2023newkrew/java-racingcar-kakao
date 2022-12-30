package CarRacing;

import CarRacing.domain.Racing;
import CarRacing.domain.RacingResult;
import CarRacing.view.InputView;
import CarRacing.view.ResultView;


public class Controller {
    public static void main(String[] args) {
        while(true) {
            String inputNames = InputView.inputNames();
            String inputCount = InputView.inputCount();
            Racing racing;
            try {
                racing = new Racing(inputNames, inputCount);
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }
            RacingResult racingResult = racing.playRacing();
            ResultView.printRacingResult(racingResult);
            break;
        }
    }
}
