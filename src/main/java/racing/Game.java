package racing;

import racing.domain.Car;
import racing.domain.Racing;
import racing.domain.Result;
import racing.view.In;
import racing.view.Out;

import java.util.List;

public class Game {

    static Racing racing = new Racing();
    static Result result = new Result();
    static Car[] carList;

    public static void handleNames() {
        Out.printInputNameRequest();
        String inputNames = In.inputNames();
        carList = racing.createCars(inputNames);
    }

    public static void playRacing() {
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
        List<String> winners = result.getWinner(carList);
        Out.printWinners(winners);
    }

    public static void main(String[] args) {
        handleNames();
        playRacing();
        winnerResult();
    }

}
