package racing_car;

import racing_car.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.initGame();
    }
}
