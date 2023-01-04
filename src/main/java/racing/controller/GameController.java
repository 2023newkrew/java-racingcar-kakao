package racing.controller;

import racing.view.GameView;
import racing.domain.game.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.IntStream.*;

public class GameController {

    private final Scanner scanner;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        GameView gameView = new GameView();
        gameView.printCarNamesInputRequestMessage();
        List<String> carNames = Arrays.asList(scanner.nextLine().split(","));
        gameView.printTriesInputRequestMessage();
        int tries = scanner.nextInt();

        Game game = new Game(carNames);

        gameView.printGameStartMessage();
        range(0, tries).forEach(i -> gameView.printResult(game.playTurn()));
        gameView.printWinner(game.getWinnerNames());
    }
}
