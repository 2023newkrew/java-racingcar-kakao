package mvc;

import mvc.domain.Car;
import mvc.domain.CarFactory;
import mvc.domain.Game;
import mvc.view.InputView;
import mvc.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String carNameStr = inputView.inputCarNameStr();
        int totalTurn = inputView.inputTotalTurn();

        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createCarsFromNameStr(carNameStr);

        Game game = new Game(cars, totalTurn);
        outputView.printInit(game.getCarList());

        while (!game.isEnd()) {
            game.playOneTurn();
            outputView.printCars(game.getCarList());
        }
        outputView.printWinners(game.findWinners());
    }
}
