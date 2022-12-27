package CarRacing;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        View view = new View();
        Racing racing = new Racing();

        String inputNames = view.inputNames();
        String[] names = racing.handleNames(inputNames);
        Car[] carList = racing.makeCarList(names);

        int inputCount = view.inputCount();

        view.printText();
        view.printResult(carList);
        for (int i = 0; i < inputCount; i++) {
            carList = racing.oneCycle(carList);
            view.printResult(carList);
        }
        List<String> winners = racing.getWinner(carList);
        view.printWinners(winners);
    }
}
