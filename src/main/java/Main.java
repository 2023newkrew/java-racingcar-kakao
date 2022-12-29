import racingcar.domain.Game;
import racingcar.view.IOHelper;

public class Main {
    public static void main(String[] args) {
        IOHelper ioHelper = new IOHelper();

        Game game = new Game();
        game.run(ioHelper);

        ioHelper.close();
    }
}
