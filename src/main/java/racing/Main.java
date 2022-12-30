package racing;

import racing.domain.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameView gameView = new GameView(game);
        gameView.init();
        gameView.gameStart();
        gameView.gameFinish();
    }
}
