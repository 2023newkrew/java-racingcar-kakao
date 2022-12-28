package racing_car.controller;

import racing_car.model.Cars;
import racing_car.model.Game;
import racing_car.view.GameView;

public class GameController {

    private final GameView gameView = new GameView();

    public void initGame() {
        Cars cars = Cars.of(separateCarNamesByDelimiter(gameView.getCarNamesWithDelimiter()));

        Game game = new Game(cars);
        int playCount = gameView.getPlayCount();

        System.out.println("실행결과");
        for (; playCount > 0; --playCount) {
            game.moveAllCars();
            gameView.printGameProcess(game.getCars());
        }

        gameView.printGameResult(game.getWinners());
    }

    private String[] separateCarNamesByDelimiter(String target) {

        return separateCarNamesByDelimiter(",", target);
    }

    private String[] separateCarNamesByDelimiter(String delimiter, String target) {

        return target.split(delimiter);
    }
}
