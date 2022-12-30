package racing;

import java.util.stream.IntStream;
import racing.domain.Game;

public class GameController {

    private final GameView gameView;
    private Game game;
    private int tryCount;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void start() {
        gameSetting();
        gameStart();
        gameFinish();
    }

    private void gameSetting() {
        this.game = new Game(gameView.receiveCarNamesFromUser());
        this.tryCount = gameView.receiveTryCountFromUser();
    }

    private void gameStart() {
        gameView.printStart();
        IntStream.range(0, tryCount)
                .forEach(i -> gamePlay());
    }

    private void gamePlay() {
        game.play();
        gameView.printStatus(game.getCars());
    }

    private void gameFinish() {
        gameView.printFinish(game.getWinnerNames());
    }


}
