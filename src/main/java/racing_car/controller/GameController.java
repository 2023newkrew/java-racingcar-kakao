package racing_car.controller;

import racing_car.model.Cars;
import racing_car.model.Game;
import racing_car.strategy.MoveByRandom;
import racing_car.view.InputView;
import racing_car.view.OutputView;

public class GameController {

    private final InputView inputView = new InputView();

    private final OutputView outputView = new OutputView();

    public void initGame() {
        Cars cars = Cars.of(separateCarNamesByDelimiter(inputView.getCarNamesWithDelimiter()));

        Game game = new Game(cars, new MoveByRandom());
        int playCount = inputView.getPlayCount();

        System.out.println("실행결과");
        for (; playCount > 0; --playCount) {
            game.moveAllCars();
            outputView.printGameProcess(game.getCars());
        }

        outputView.printGameResult(game.getWinners());
    }

    private String[] separateCarNamesByDelimiter(String target) {

        return separateCarNamesByDelimiter(",", target);
    }

    private String[] separateCarNamesByDelimiter(String delimiter, String target) {

        return target.split(delimiter);
    }
}
