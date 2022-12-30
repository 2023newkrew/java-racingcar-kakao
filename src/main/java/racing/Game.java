package racing;

import racing.domain.Car;
import racing.domain.CarList;
import racing.domain.Racing;
import racing.domain.Result;
import racing.view.In;
import racing.view.Out;

import java.util.List;

public class Game {

    static CarList carList;

    public static void handleNames() {
        Out.printInputNameRequest();
        String inputNames = In.inputNames();
        carList = new CarList(inputNames);
    }

    public static void playRacing() {
        Racing racing = new Racing();
        Out.printInputCountRequest();
        int inputCount = In.inputCount();
        Out.printResultStartSentence();
        Out.printResult(carList);
        for (int count = 0; count < inputCount; count++) {
            carList = racing.oneCycle(carList);
            Out.printResult(carList);
        }
    }

    public static void winnerResult() {
        Result result = new Result();
        List<String> winners = result.getWinner(carList);
        Out.printWinners(winners);
    }

    public static void main(String[] args) {
        handleNames();
        playRacing();
        winnerResult();
    }

}
