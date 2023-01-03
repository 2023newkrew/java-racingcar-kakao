package racing;

import racing.domain.CarList;
import racing.domain.Racing;
import racing.domain.Result;
import racing.view.In;
import racing.view.Out;

import java.util.List;

public class Game {

    public static CarList playRacing(CarList carList) {
        Racing racing = new Racing();
        Out.printInputCountRequest();
        int inputCount = In.inputCount();
        Out.printResultStartSentence();
        Out.printResult(carList);
        for (int count = 0; count < inputCount; count++) {
            carList = racing.oneCycle(carList);
            Out.printResult(carList);
        }
        return carList;
    }

    public static void winnerResult(CarList carList) {
        Result result = new Result();
        List<String> winners = result.getWinner(carList);
        Out.printWinners(winners);
    }

    public static void main(String[] args) {
        Out.printInputNameRequest();
        String inputNames = In.inputNames();
        CarList carList = new CarList(inputNames);
        carList = playRacing(carList);
        winnerResult(carList);
    }

}
