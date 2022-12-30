package racingcar;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameRunner {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();


    public void run() {
        Integer numberOfGames;
        List<Car> carList = inputView.inputData();
        numberOfGames = inputView.getNumberOfGames();

        for (int i = 0; i < numberOfGames; i++) {
            carList.forEach(Car::move);
            outputView.printCars(carList);
            System.out.println();
        }
        outputView.printWinners(carList);
    }
}