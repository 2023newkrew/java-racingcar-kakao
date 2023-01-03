package racing;

import java.util.stream.IntStream;
import racing.domain.Game;

public class GameController {

    private final GameView gameView;
    private int tryCount;
    private Game game;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void start() {
        setGame();
        startGame();
        finishGame();
    }

    private void setGame() {
        this.game = new Game(gameView.receiveCarNamesFromUser());
        this.tryCount = gameView.receiveTryCountFromUser();
    }

    private void startGame() {
        gameView.printStart();
        IntStream.range(0, tryCount)
                .forEach(i -> playGame());
    }

    private void playGame() {
        game.play();
        gameView.printStatus(game.getCars());
    }

    private void finishGame() {
        gameView.printFinish(game.getWinnerNames());
    }


}
