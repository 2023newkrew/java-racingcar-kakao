package CarRacing;

import java.util.List;

public class Controller {
    static View view = new View();
    static Racing racing = new Racing();
    static Car[] carList;

    public static void handleNames() {
        String inputNames = view.inputNames();
        String[] names = racing.handleNames(inputNames);
        carList =  racing.makeCarList(names);
    }

    public static void playRacing() {
        int inputCount = view.inputCount();
        view.printText();
        view.printResult(carList);
        for (int i = 0; i < inputCount; i++) {
            carList = racing.oneCycle(carList);
            view.printResult(carList);
        }
    }

    public static void winnerResult() {
        List<String> winners = racing.getWinner(carList);
        view.printWinners(winners);
    }

    public static void main(String[] args) {
        handleNames();
        playRacing();
        winnerResult();
    }
}
