package CarRacing;

import CarRacing.domain.Car;
import CarRacing.domain.Racing;
import CarRacing.view.InputView;
import CarRacing.view.ResultView;

import java.util.List;

public class Controller {
    private static Car[] carList;

    public static void handleNames(Racing racing) {
        String inputNames = InputView.inputNames();
        String[] names = racing.handleNames(inputNames);
        carList =  racing.makeCarList(names);
    }

    public static void playRacing(Racing racing) {
        int inputCount = InputView.inputCount();
        ResultView.printResult(carList);
        for (int count = 0; count < inputCount; count++) {
            carList = racing.oneCycle(carList);
            ResultView.printResult(carList);
        }
    }

    public static void winnerResult(Racing racing) {
        List<String> winners = racing.getWinner(carList);
        ResultView.printWinners(winners);
    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        handleNames(racing);
        playRacing(racing);
        winnerResult(racing);
    }
}
