import racingcar.Controller;
import racingcar.domain.Game;
import racingcar.view.InputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Game game = new Game();
        Controller controller = new Controller(inputView, game);

        controller.playGame();
    }
}
