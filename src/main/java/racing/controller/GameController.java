package racing.controller;

import racing.view.GameView;
import racing.domain.Game;

import java.util.Scanner;

import static java.util.stream.IntStream.*;

public class GameController {

    private final Scanner scanner;
    private final GameView gameView;
    private final Game game;

    public GameController() {
        this.scanner = new Scanner(System.in);
        this.game = new Game();
        this.gameView = new GameView();
    }

    public void run() {
        gameView.printCarNamesInputRequestMessage();
        String[] carNames = scanner.nextLine().split(",");
        gameView.printTriesInputRequestMessage();
        int tries = scanner.nextInt();

        game.initialize(carNames);

        gameView.printGameStartMessage();
        range(0, tries).forEach(i -> gameView.printResult(game.playTurn()));
        gameView.printWinner(game.getWinnerNames());
    }
}
