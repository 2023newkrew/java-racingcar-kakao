package racing.controller;

import java.util.List;
import racing.service.Game;
import racing.view.InputView;
import racing.view.OutputView;

public class GameController {
    private static final String RESULT_MESSAGE = "실행 결과";
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
            System.out.println(RESULT_MESSAGE);
            playMultipleTurns(repeat);
            outputView.printWinner(game.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            play();
        }
    }

    private void playMultipleTurns(int repeat) {
        for (int i = 0; i < repeat; i++) {
            playSingleTurn();
        }
    }

    private void playSingleTurn() {
        game.play();
        outputView.printResult(game.getStatus());
    }
}
