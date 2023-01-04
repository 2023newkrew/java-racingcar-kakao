package racing.controller;

import racing.domain.Game;
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
        try {
            String carNames = inputView.readCarNames();
            int gameTurn = inputView.readGameTurn();

            game = new Game(carNames, gameTurn);
            outputView.printResultIntro();
            playGame();
            outputView.printWinner(game.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private void playGame() {
        while (!game.isEnd()) {
            game.play();
            outputView.printResult(game.getStatus());
        }
    }

}
