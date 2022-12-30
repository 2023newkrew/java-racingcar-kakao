package mvc;

import mvc.domain.CarConverter;
import mvc.domain.Game;
import mvc.view.InputView;
import mvc.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String carNameStr = InputView.inputCarNameStr();
        int totalTurn = InputView.inputTotalTurn();

        Game game = new Game(CarConverter.nameStrToCarList(carNameStr), totalTurn);
        OutputView.printInit(game.getCarList());

        while (!game.isEnd()) {
            game.playOneTurn();
            OutputView.printCars(game.getCarList());
        }
        OutputView.printWinners(game.findWinners());
    }
}
