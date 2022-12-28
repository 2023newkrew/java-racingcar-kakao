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
        setGameRepeat();
        System.out.println(RESULT_MESSAGE);
        while (!game.isOver()) {
            playSingleTurn();
        }
        outputView.printWinner(game.getWinners());
    }

    private void initialize() {
        try {
            List<String> rawCarNames = inputView.readCarNames();
            game = new Game(rawCarNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initialize();
        }
    }

    private void setGameRepeat() {
        try {
            int repeat = inputView.readGameRepeat();
            game.setRepeat(repeat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setGameRepeat();
        }
    }

    private void playSingleTurn() {
        game.play();
        outputView.printResult(game.getStatus());
    }
}
