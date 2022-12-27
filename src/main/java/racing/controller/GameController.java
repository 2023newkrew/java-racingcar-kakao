package racing.controller;

import java.util.List;
import racing.service.Game;
import racing.view.InputView;
import racing.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private Game game;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        List<String> carNames = inputView.readCarNames();
        game = new Game(carNames);
        for (int i = 0; i < inputView.readGameRepeat(); i++) {
            game.play();
            outputView.printResult(game.getStatus());
        }
        outputView.printWinner(game.getWinners());
    }
}
