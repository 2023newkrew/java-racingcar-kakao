package racing;

public class Main {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameView);
        gameController.start();
    }
}
