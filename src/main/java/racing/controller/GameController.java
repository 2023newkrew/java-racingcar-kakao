package racing.controller;

import java.util.List;
import racing.service.Game;
import racing.view.InputView;
import racing.view.OutputView;

public class GameController {
    private static final String RESULT_MESSAGE = "실행 결과";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Game game;

    public void run() {
        initialize();
        int repeat = inputView.readGameRepeat();
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < repeat; i++) {
            playSingleTurn();
        }
        outputView.printWinner(game.getWinners());
    }

    private void initialize() {
        try {
            List<String> rawCarNames = inputView.readCarNames();
            game = new Game(rawCarNames);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initialize();
        }
    }

    private void playSingleTurn() {
        game.play();
        outputView.printResult(game.getStatus());
    }
}
