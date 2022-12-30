package racing.controller;

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
        try {
            String carNames = inputView.readCarNames();
            int repeat = inputView.readGameRepeat();

            game = new Game(carNames);
            outputView.printResultIntro();
            playGameMultipleTurns(repeat);
            outputView.printWinner(game.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private void playGameMultipleTurns(int repeat) {
        for (int i = 0; i < repeat; i++) {
            game.play();
            outputView.printResult(game.getStatus());
        }
    }

}
